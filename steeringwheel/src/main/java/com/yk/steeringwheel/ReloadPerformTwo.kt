package com.yk.steeringwheel

import java.util.*

/**
 * @Description:
 * @author: liuzhixiang
 * @date: 2021/3/25
 * @mail: liuzhixiang@em-data.com.cn
 */
class ReloadPerformTwo {
    var i_on = 3
    val i_off = 4
        get() {
            Thread(Runnable { }).run()
            return field
        }
    var s_on = "sfsdf"
    private val s_off = "erterte"

    inner class Me {
        private val ME_i_on = 3
        private val ME_i_off = 4
        var ME_s_on = "sfsdf"
        private val ME_s_off = "erterte"
        fun pva(): Int {
            return 2 + ME_i_off
        }

        private fun _pva(): Int {
            return 1 + i_on
        }
    }

    class Te {
        private val me_id_off_te = 546456
        var me_id_on_asda = "liuzhix"

        companion object {
            var TE_I_S_ON = 1
            private const val TE_I_S_OFF = 2
            var TE_S_S_ON = "aaaaa"
            private const val TE_S_S_OFF = "bbbbbb"
            fun psi(): Int {
                return TE_I_S_OFF + 1000
            }

            private fun _psi(): Int {
                return TE_I_S_OFF + 1000
            }
        }
    }

    class Ti {
        private val sa = intArrayOf(1, 2, 3, 4, 56, 7)
        private val namelsit: ArrayList<String>? = null

        companion object {
            var TI_I_S_ON = 1
            private const val TOI_S_S_OFF = "bbbbbb"
            fun psiTi(): Int {
                return TI_I_S_ON + 1000
            }

            private fun _psi(): Int {
                return TI_I_S_ON + 1000
            }
        }
    }

    internal interface OnMyinterface {
        fun maxdaxiao(): Int
    }

    internal abstract inner class Oeaclass {
        var c = 1000
        abstract fun osfsdf()
    }

    companion object {
        var i_s_on = 1
        private const val i_s_off = 2
        var s_s_on = "aaaaa"
        private const val s_s_off = "bbbbbb"
        fun _getI_off(): Int {
            return i_s_off
        }
    }
}