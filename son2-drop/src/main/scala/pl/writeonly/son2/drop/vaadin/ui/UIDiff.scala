package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.drop.vaadin.util.{Mappings, UITrait}
import pl.writeonly.son2.path.core.ConfigPath
import pl.writeonly.son2.path.glue.CreatorConverterPathMain

import scala.collection.JavaConverters._

@Title("json path")
@Theme("valo")
class UIDiff extends UITrait {
  override def components2: List[Component] = {
    val checkBoxes = nativeGroup
    val configLabel = outputLabel
    val input = inputTextArea
    val output = outputLabel

    val providerGroup = radioButtonGroup("Providers", Mappings.pathProvidersMapping, "Smart");
    val outputFormats = jacksonOutputFormat("JSON")
    val components: List[Component] = List(providerGroup, outputFormats, checkBoxes, configLabel)

    val inputPatch = inputTextArea("json-patch")

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val path = inputPatch.getValue
        val config = ConfigPath(i = Symbol(path))

        val set = checkBoxes.getValue.asScala.toSet
        debug(configLabel, config, set)
        convert2(CreatorConverterPathMain(config), input, output, set)
      }
    })

    return List( optionsPanel(components), inputPatch, input, convert, output)
  }
}