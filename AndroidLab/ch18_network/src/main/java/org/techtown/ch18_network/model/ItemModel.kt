package org.techtown.ch18_network.model

// 서버에서 넘어오는 기사 내용 저장

class ItemModel{
    var id: Long=0
    var author: String? =null
    var title: String? = null
    var description: String? = null
    var urlToImage: String? = null
    var publishedAt: String ?= null
}