package pl.writeonly.son2.json.notation

import com.google.gson.{JsonElement, JsonParser}
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderJackson() extends NotationReader {
  def apply(content: String): JsonElement = new JsonParser().parse(content)
}
