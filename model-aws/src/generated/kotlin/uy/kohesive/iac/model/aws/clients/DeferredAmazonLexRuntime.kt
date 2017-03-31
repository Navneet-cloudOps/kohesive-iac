package uy.kohesive.iac.model.aws.clients

import com.amazonaws.services.lexruntime.AbstractAmazonLexRuntime
import com.amazonaws.services.lexruntime.AmazonLexRuntime
import uy.kohesive.iac.model.aws.IacContext

open class BaseDeferredAmazonLexRuntime(val context: IacContext) : AbstractAmazonLexRuntime(), AmazonLexRuntime {


}

class DeferredAmazonLexRuntime(context: IacContext) : BaseDeferredAmazonLexRuntime(context)
