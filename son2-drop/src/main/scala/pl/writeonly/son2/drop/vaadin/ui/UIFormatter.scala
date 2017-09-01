package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.annotations.{Theme, Title}
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui._
import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.json.glue.CreatorConverterJson

import scala.collection.JavaConverters._

@Title("json formatter")
@Theme("valo")
class UIFormatter extends UITrait {

  override def components: List[Component] = {
    val checkBoxes = nativeGroup
    val configLabel = outputLabel
    val input = inputTextArea
    val output = outputLabel

    val providers = List[String]("Gson", "Jackson", "Smart")

    val providerGroup = new RadioButtonGroup[String]("Providers", providers.asJavaCollection)
    providerGroup.setSelectedItem(providers(0))

    val components: List[Component] = List(providerGroup, checkBoxes, configLabel)

    val convert = convertButton(new Button.ClickListener() {
      override def buttonClick(clickEvent: ClickEvent): Unit = {
        val provider = providerGroup.getSelectedItem.get().toLowerCase
        val providerSymbol = Symbol(provider)

        val config = Config(
          RConfig(format = providerSymbol),
          WConfig(format = providerSymbol)
        )
        val set = checkBoxes.getValue.asScala.toSet
        debug(configLabel, config, set)
        convert2(CreatorConverterJson(config), input, output, set)
      }
    })

    return List(linkPanel, optionsPanel(components), input, convert, output)
  }
}