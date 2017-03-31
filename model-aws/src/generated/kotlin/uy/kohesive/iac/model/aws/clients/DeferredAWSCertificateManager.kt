package uy.kohesive.iac.model.aws.clients

import com.amazonaws.services.certificatemanager.AbstractAWSCertificateManager
import com.amazonaws.services.certificatemanager.AWSCertificateManager
import com.amazonaws.services.certificatemanager.model.*
import uy.kohesive.iac.model.aws.IacContext
import uy.kohesive.iac.model.aws.proxy.makeProxy

open class BaseDeferredAWSCertificateManager(val context: IacContext) : AbstractAWSCertificateManager(), AWSCertificateManager {


}

class DeferredAWSCertificateManager(context: IacContext) : BaseDeferredAWSCertificateManager(context)
