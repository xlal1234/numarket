package com.numarket.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numarket.common.pojo.EUTreeNode;
import com.numarket.common.utils.TaotaoResult;
import com.numarket.mapper.TbContentCategoryMapper;
import com.numarket.pojo.TbContentCategory;
import com.numarket.pojo.TbContentCategoryExample;
import com.numarket.pojo.TbContentCategoryExample.Criteria;
import com.numarket.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	@Override
	public List<EUTreeNode> getCategoryList(long parentId) {
		//根据parentid查询节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		for (TbContentCategory tbContentCategory : list) {
			//创建一个节点
			EUTreeNode node = new EUTreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			
			resultList.add(node);
		}
		return resultList;
	}
	@Override
	public TaotaoResult insertContentCategory(long parentId, String name) {
				
		//创建一个pojo
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		//'状态。可选值:1(正常),2(删除)',
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		//添加记录
		contentCategoryMapper.insert(contentCategory);
		//查看父节点的isParent列是否为true，如果不是true改成true
		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
		//判断是否为true
		if(!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		//返回结果
		return TaotaoResult.ok(contentCategory);

	}
	@Override
	public TaotaoResult deleteContentCategory(long id) {
		
		TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);  
        //判断删除的节点是否为父类
        if(contentCategory.getIsParent()){
           List<TbContentCategory> list=getContentCategoryListByParentId(id);
           //递归删除
            for(TbContentCategory tbContentCategory : list){ 
                deleteContentCategory(contentCategory.getId());
            }
       }
        //判断父类中是否还有子类节点，没有的话，把父类改成子类  if(getContentCategoryListByParentId(contentCategory.getParentId()).size()==1)
       {
           TbContentCategory parentCategory=contentCategoryMapper.selectByPrimaryKey(contentCategory.getParentId());
           parentCategory.setIsParent(false);
            contentCategoryMapper.updateByPrimaryKey(parentCategory);
       }
       contentCategoryMapper.deleteByPrimaryKey(id);
       return  TaotaoResult.ok();
   }

/**
    * 获取该节点下的孩子节点
    * @param id
    * @return 父节点下的所有孩子节点
    */
   //通过父节点id来查询所有子节点，这是抽离出来的公共方法  
   private List<TbContentCategory> getContentCategoryListByParentId(long id){  
       TbContentCategoryExample example = new TbContentCategoryExample();  
       Criteria criteria = example.createCriteria();  
       criteria.andParentIdEqualTo(id);  
       List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);  
       return list;  
   }
   @Override
	public TaotaoResult renameContentCategory(long id, String name) {
		TbContentCategory contentCategory= contentCategoryMapper.selectByPrimaryKey(id);
	    TbContentCategory a=new TbContentCategory();
	    a.setName(name);
	    a.setUpdated(new Date());
	    a.setId(contentCategory.getId());
	    a.setIsParent(contentCategory.getIsParent());
	    a.setCreated(contentCategory.getCreated());
	    a.setParentId(contentCategory.getParentId());
	    a.setSortOrder(contentCategory.getSortOrder());
	    a.setStatus(contentCategory.getStatus());
	    contentCategoryMapper.updateByPrimaryKey(a);
	    return TaotaoResult.ok();
	}  

}
