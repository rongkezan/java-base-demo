package com.demo.test.json;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author <a href="mailto:yourname@zjport.gov.cn">yourname</a>
 * @version $Id$
 * @since 2.0
 */
@Data
public class DubDeclareBillDetailProviderVo implements Serializable {

    private static final long serialVersionUID = 1794300622684691273L;

    /**
     * 提运单号
     */
    private String billNo;

    /**
     * 商品序号
     */
    private String gNo;

    /**
     * 项号
     */
    private String relManNo;

    /**
     * 商品编号
     */
    private String codeT;

    /**
     * 商品名称
     */
    private String gName;

    /**
     * 规格型号
     */
    private String gModel;

    /**
     * 成交数量
     */
    private String gQty;

    /**
     * 成交单位
     */
    private String gUnitName;

    /**
     * 成交单位
     */
    private String gUnit;

    /**
     * 成交总价
     */
    private String declTotal;

    /**
     * 币制
     */
    private String declCurrName;

    /**
     * 币制
     */
    private String declCurr;

    /**
     * 成交单价
     */
    private String declPrice;

    /**
     * 版本号
     */
    private String exgVersion;

    /**
     * 货号
     */
    private String goodsNo;

    /**
     * 原产国
     */
    private String originCountryName;

    /**
     * 原产国
     */
    private String originCountry;

    private String tempCountry;

    /**
     * 第一单位
     */
    private String unit1Name;

    /**
     * 第一单位
     */
    private String unit1;

    /**
     * 第一数量
     */
    private String qty1;

    /**
     * 第二单位
     */
    private String unit2Name;

    /**
     * 第二单位
     */
    private String unit2;

    /**
     * 第二数量
     */
    private String qty2;

    /**
     * 征减免税方式
     */
    private String dutyModeName;

    /**
     * 征减免税方式
     */
    private String dutyMode;

    /**
     * 工缴费
     */
    private String workUsd;

    /**
     * 最终目的国
     */
    private String destCountryName;

    /**
     * 最终目的国
     */
    private String destCountry;

    /**
     * 申报要素
     */
    private String mainFactor;

    /**
     * 信息代码
     */
    private String rtnCode;

    /**
     * 信息
     */
    private String rtnInfo;

    /**
     * 校验标志
     */
    private String invalid = "1";

    /**
     * 涉税
     */
    private String dutyType;

    /**
     * 涉税名称
     */
    private String dutyTypeName;

    /**
     * 涉通关单
     */
    private String tariffMark;

    /**
     * 涉通关单Name
     **/
    private String tariffMarkName;

    /**
     * 监管方式
     */
    private String controlMark;

    /*关检合并新增字段*/
    /**
     * 检验检疫编码
     */
    private String ciqCode;
    /**
     * 检验检疫名称
     */
    private String ciqName;

    /**
     * 商品英文名称
     */
    private String declGoodsEname;

    /**
     * 原产地区代码
     */
    private String origPlaceCode;
    /**
     * 原产地区Name
     */
    private String origPlaceName;

    /**
     * 用途代码
     */
    private String purpose;
    /**
     * 用途代码Name
     */
    private String purposeName;

    /**
     * 目的地代码（检验检疫）
     */
    private String ciqDestCode;
    /**
     * 目的地代码（检验检疫） Name
     */
    private String ciqDestName;

    /**
     * 境内目的地/境内货源地
     */
    private String districtCode;

    /**
     * 境内目的地/境内货源地Name
     */
    private String districtName;

    /**
     * 货物属性代码
     */
    private String goodsAttr;

    /**
     * 成份/原料/组份
     */
    private String stuff;
    /**
     * 产品有效期
     */
    private Date prodValidDt;
    /**
     * 产品保质期
     */
    private String prodQgp;
    /**
     * 境外生产企业名称
     */
    private String engManEntCnm;
    /**
     * 货物规格
     */
    private String goodsSpec;
    /**
     * 货物型号
     */
    private String goodsModel;
    /**
     * 货物品牌
     */
    private String goodsBrand;
    /**
     * 生产日期
     */
    private Date produceDate;
    /**
     * 生产批号
     */
    private String prodBatchNo;
    /**
     * 生产单位注册号
     */
    private String mnufctrRegNo;

    /**
     * 非危险化学品标识
     */
    private String noDangFlag;
    /**
     * un 编码
     */
    private String unCode;
    /**
     * 危险货物名称
     */
    private String dangName;
    /**
     * 危包类别
     */
    private String packType;
    /**
     * 危包规格
     */
    private String packSpec;
    /**
     * 信号旗订单号
     */
    private String orderNoXhq;

    public String getgModel() {
        return gModel;
    }

    public void setgModel(String gModel) {
        this.gModel = gModel;
    }

    public String getgQty() {
        return gQty;
    }

    public void setgQty(String gQty) {
        this.gQty = gQty;
    }

    public String getgUnitName() {
        return gUnitName;
    }

    public void setgUnitName(String gUnitName) {
        this.gUnitName = gUnitName;
    }

    public String getgUnit() {
        return gUnit;
    }

    public void setgUnit(String gUnit) {
        this.gUnit = gUnit;
    }
}
