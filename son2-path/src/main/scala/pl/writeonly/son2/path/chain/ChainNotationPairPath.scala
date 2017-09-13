package pl.writeonly.son2.path.chain

import pl.writeonly.son2.core.converters.CreatorConverter
import pl.writeonly.son2.path.glue.{ChainNotationConfigPathMain, ChainNotationRWTPath}

object ChainNotationPairPath extends CreatorConverter(new ChainNotationConfigPathMain(), new ChainNotationRWTPath())