import com.domain.MySecurityEventListener

// Place your Spring DSL code here
beans = {
    mySecurityEventListener(MySecurityEventListener) {
        privilegeService = ref('privilegeService')
    }
}
