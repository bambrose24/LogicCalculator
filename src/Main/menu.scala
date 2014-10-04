package Main


object Menu {
	import scala.swing._
	import scala.swing.BorderPanel.Position._
	import event._
	import java.awt.{ Color, Graphics2D }
	import scala.util.Random
	// Build menu
  val frame = new MainFrame {
	 title = "Computer Science 250 Propositional Logic Calculator"
	   background = Color.black
	 val label = new Label("CS250 Propositional Logic Calculator")
	 //contents = new TextComponent()
	 val button = new Button{
	   text = "CALCULATE"
	   foreground = Color.black
	   foreground = Color.red
	 }
	 val textField = new TextField(20){
	   border = Swing.EmptyBorder(30)
	 }
	 // Intro
	   // Instructions
	 //Text field submission
	 // Options
	 contents = new BorderPanel {
	   layout(label) = North
	   layout(button) = South
	   layout(textField) = Center
	 }
	 
	size = new Dimension(500,500)
  }
}
