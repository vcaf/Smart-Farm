package com.avansb.smartfarm.model

data class Irrigation(
     val id:Int,
     val irrigId: String,
     val irrigName: String,
     val irrigSupplierName:String,
     val irrigSupplierEmail: String,
     val irrigType:String,
     val irrigState:String,
     val irrigDate: String)