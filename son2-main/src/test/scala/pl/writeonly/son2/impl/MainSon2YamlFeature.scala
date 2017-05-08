package pl.writeonly.son2.impl

import java.io.FileNotFoundException

import org.scalatest.{FeatureSpec, GivenWhenThen}
import pl.writeonly.son2.core.core.Formats
import pl.writeonly.son2.impl.main.Main
import pl.writeonly.son2.spec.FeatureWhenThen

class MainSon2YamlFeature extends FeatureWhenThen {

  info(classOf[MainSon2YamlFeature].getSimpleName)

  val outName = (name: String) => Features.outputPathname(Types.MAIN, name, Formats.YAML)

  feature(classOf[MainSon2YamlFeature].getSimpleName) {
    ignore("Apply with null pathname") {
      Given("converter FileJson2Yaml")

      When("should produce null when consume null")
      val name: String = null
      val caught = intercept[NullPointerException] {
        Main.main(Array(Formats.YAML, name, name))
      }

      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    ignore("Apply with empty pathname") {
      Given("converter FileJson2Yaml")

      When("should produce empty when consume empty")
      assertThrows[FileNotFoundException] {
        Main.main(Array(Formats.YAML, "", ""))
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      val in = Features.inputPathname
      val out = outName("pathname")

      When("should produce null when consume null")
      Main.main(Array(Formats.YAML, in, out))
    }
  }
}

