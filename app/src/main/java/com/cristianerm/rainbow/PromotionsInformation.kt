package com.cristianerm.rainbow

data class PromotionsInformation(

    var desconto: String,

    var evento_servico: String

) {

    override fun toString(): String {
        return "BlogPost(desconto='$desconto', evento_servico='$evento_servico')"
    }


}