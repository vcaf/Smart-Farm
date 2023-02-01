package com.avansb.smartfarm.machinelearning

class ID3 {
    fun id3datacast(iD3Model: ID3Model):ID3String {
        val temperatuur = iD3Model.temperatuur
        val grond = iD3Model.grond
        val wind = iD3Model.wind
        val gassen = iD3Model.gassen
        var temp =""
        var soil =""
        var gas =""
        var wnd =""

        when (temperatuur) {
            in Int.MIN_VALUE..15 -> {
                temp = "cold"
            }
            in 16..21 -> {
                temp = "normal"
            }
            in 22..Int.MAX_VALUE -> {
                temp = "cold"
            }
        }
        when (grond) {
            in Int.MIN_VALUE..9 -> {
                soil = "dry"
            }
            in 10..70 -> {
                soil = "normal"
            }
            in 71..Int.MAX_VALUE -> {
                soil = "wet"
            }
        }
        when (gassen) {
            in 350..450 -> {
                gas = "normal"
            }
            in 451..Int.MAX_VALUE -> {
               gas = "high"
            }
        }
        when (wind) {
            in 0..15 -> {
                wnd = "soft"
            }
            in 16..Int.MAX_VALUE -> {
                wnd = "hard"
            }
        }
       return ID3String(temp,soil,wnd,gas)
    }

}
