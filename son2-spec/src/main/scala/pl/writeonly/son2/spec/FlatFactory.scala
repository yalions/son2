package pl.writeonly.son2.spec

import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec
import org.scalatest.prop.Checkers

abstract class FlatFactory extends FlatSpec with MockFactory with Checkers {

}
