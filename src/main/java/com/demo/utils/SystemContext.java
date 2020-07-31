 /**************************************************************************
 * Copyright (c) 2006-2017 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 * 
 * 项目名称：报关服务平台2.0
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.demo.utils;

import org.apache.commons.lang3.StringUtils;

 /**
  * 系统上下文
  * @author <a href="mailto:wujun@zjport.gov.cn">wujun</a>
  * @version $Id$
  * @since 2.0
  */
 public class SystemContext {
     public static final String SUCCESS_CODE = "000000";
     /**
      * 默认用户ID
      */
     public static String DEFAULT_USER_ID = "SYSTEM";

     public static final String YMD = "yyyyMMdd";

     public static final String Y_M_D = "yyyy-MM-dd";

     public static final String TRUE = "1";

     public static final String FALSE = "0";

     public static final String SUCCESS = "0";

     public static final String FAILED = "1";

     public static final int NUMBER_SCALE=5;

     private static ThreadLocal<String> currentUserId = new ThreadLocal<String>();

     public static String getCurrentUserId() {
         String _currentUserId = currentUserId.get();
         if (StringUtils.isEmpty(_currentUserId)) {
             _currentUserId = DEFAULT_USER_ID;
         }
         return _currentUserId;
     }

     public static void setCurrentUserId(String _currentUserId) {
         currentUserId.set(_currentUserId);
     }

     public static void removeCurrentUserId() {
         currentUserId.remove();
     }

 }
