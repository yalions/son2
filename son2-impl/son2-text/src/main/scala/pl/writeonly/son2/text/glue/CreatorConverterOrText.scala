package pl.writeonly.son2.text.glue

import pl.writeonly.son2.core.glue.CreatorConverterOr
import pl.writeonly.son2.text.creators.PCreatorConfigText

class CreatorConverterOrText
  extends CreatorConverterOr(
    new PCreatorConfigText,
    new ChainNotationRWTText())
