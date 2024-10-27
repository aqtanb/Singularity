package kz.singularity.jetpackcomposemost.example.example_hilt

import javax.inject.Inject

class HiltClassWithParams @Inject constructor(
    private val params: HiltClassWithoutParams,
) {

    fun execute() {
        params.execute()
    }
}
