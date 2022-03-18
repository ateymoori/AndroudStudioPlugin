package amir.github.actions

import com.intellij.openapi.wm.ToolWindow
import java.awt.event.ActionEvent
import java.util.*
import javax.swing.*


//class MyToolWindow : ToolWindowFactory {
//    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
//
////        println("createToolWindowContent")
////        val contentManager: ContentManager = toolWindow.contentManager
////        val content: Content =
////            contentManager.getFactory().createContent(WebBrowserToolWindowPanel(true, true), null, false)
////        contentManager.addContent(content)
//
//
//        println("createToolWindowContent")
//        val contentManager = toolWindow.contentManager
//        val simpleToolWindowPanel = SimpleToolWindowPanel(true, true)
//        simpleToolWindowPanel.add(JFrame())
//        val content = contentManager.factory.createContent(simpleToolWindowPanel, null, false)
//        contentManager.addContent(content)
//
//
//    }
//}


class MyToolWindow(toolWindow: ToolWindow) {
    var refreshToolWindowButton: JButton? = null
    var hideToolWindowButton: JButton? = null
    var currentDate: JLabel? = null
    var currentTime: JLabel? = null
    var timeZone: JLabel? = null
    var contentt: JPanel? = null
    var myToolWindowContent: JPanel? = null
    var textField1: JTextField? = null
    var button1: JButton? = null
    var button2: JButton? = null


    fun currentDateTime() {
        // Get current date and time
        val instance = Calendar.getInstance()
        currentDate!!.text = (instance[Calendar.DAY_OF_MONTH].toString() + "/"
                + (instance[Calendar.MONTH] + 1) + "/"
                + instance[Calendar.YEAR])
        currentDate!!.icon = ImageIcon(javaClass.getResource("/toolWindow/Calendar-icon.png"))
        val min = instance[Calendar.MINUTE]
        val strMin = if (min < 10) "0$min" else min.toString()
        currentTime!!.text = instance[Calendar.HOUR_OF_DAY].toString() + ":" + strMin
        currentTime!!.icon = ImageIcon(javaClass.getResource("/toolWindow/Time-icon.png"))
        // Get time zone
        val gmt_Offset = instance[Calendar.ZONE_OFFSET].toLong() // offset from GMT in milliseconds
        var str_gmt_Offset = (gmt_Offset / 3600000).toString()
        str_gmt_Offset = if (gmt_Offset > 0) "GMT + $str_gmt_Offset" else "GMT - $str_gmt_Offset"
        timeZone!!.text = str_gmt_Offset
        timeZone!!.icon = ImageIcon(javaClass.getResource("/toolWindow/Time-zone-icon.png"))
        textField1!!.text = "saalalal"
    }

    init {
        hideToolWindowButton!!.addActionListener { e: ActionEvent? -> toolWindow.hide(null) }
        refreshToolWindowButton!!.addActionListener { e: ActionEvent? -> currentDateTime() }
        currentDateTime()
    }

    fun getContent(): JPanel? {
        return myToolWindowContent
    }
}