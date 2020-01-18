package com.seu.miaosha.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.seu.miaosha.domain.MiaoshaGoods;
import com.seu.miaosha.vo.GoodsVo;

@Mapper
public interface GoodsDao {
	
	@Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id")
	List<GoodsVo> listGoodsVo();

	@Select("select g.*,mg.stock_count, mg.start_date, mg.end_date,mg.miaosha_price from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId}")
	GoodsVo getGoodsVoByGoodsId(@Param("goodsId") long goodsId);

	//update product set product_stock=product_stock-1,version=version+1 where id=#{id} and version=#{version};
	@Update("update miaosha_goods set stock_count = stock_count - 1 where goods_id = #{goodsId} and stock_count > 0")
	int reduceStock(MiaoshaGoods g);

	@Update("update miaosha_goods set stock_count = #{stockCount} where goods_id = #{goodsId}")
	int resetStock(MiaoshaGoods g);
}
