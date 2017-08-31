package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui._

@Title("Main UI")
@Theme("valo")
class UIMain extends UITrait {
  override def components: List[Component] = {
    return List[Component](
      link("Json Formatter", "formatter"),
      link("Json Converter", "converter"),
      link("Json Path", "path")
    )
  }
}