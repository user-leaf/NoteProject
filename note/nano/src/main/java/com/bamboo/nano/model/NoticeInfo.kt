package com.bamboo.nano.model

import java.io.Serializable

data class NoticeInfo(

    /**
     * datetime : 2019-01-30 09:57:01
     * read : true
     * level : TRADE
     * id : 9DDCC405030D4E77B43D8A9A7EFDF21E
     * readtime : 2019-01-30 10:28:22
     * title : Price alert
     * type : QUOTATION_REMINDER
     * content : When price of EURUSD reaches 1.145
     */
    var datetime: String? = null,
    var read: Boolean = false,
//    var level: NotificationLevel? = null,
    var id: String? = null,
    var readtime: String? = null,
    var title: String? = null,
//    var type: NotificationType? = null,
    var content: String? = null,
    var datetimeUTC: String? = null
) : Serializable

