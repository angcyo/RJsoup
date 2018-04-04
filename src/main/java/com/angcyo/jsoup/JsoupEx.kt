package com.angcyo.jsoup

import com.angcyo.uiview.net.Func
import com.angcyo.uiview.net.Rx
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import rx.Observable

/**
 * Copyright (C) 2016,深圳市红鸟网络科技股份有限公司 All rights reserved.
 * 项目名称：
 * 类的描述：
 * 创建人员：Robi
 * 创建时间：2018/04/04 17:54
 * 修改人员：Robi
 * 修改时间：2018/04/04 17:54
 * 修改备注：
 * Version: 1.0.0
 */

/**返回文档对象*/
public fun String.jsoup(ofWin: Boolean = true /*使用桌面UA*/): Document {
    val connect = Jsoup.connect(this)
    connect.ignoreHttpErrors(true)
            .ignoreContentType(true)
            .timeout(10_000)
            .followRedirects(true)
    //.referrer() //重定向
    if (ofWin) {
        connect.userAgent("(Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3343.4 Safari/537.36")
    }
    return connect.get()
}

public fun String.jsoupAsync(ofWin: Boolean = true): Observable<Document> {
    return Rx.create(Func<Document> { jsoup(ofWin) })
}