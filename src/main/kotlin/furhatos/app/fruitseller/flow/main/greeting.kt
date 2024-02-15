package furhatos.app.fruitseller.flow.main

import furhatos.app.fruitseller.flow.Parent
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

val Greeting: State = state(Parent) {
    onEntry {
        furhat.say {
            random {
                +"Hi there"
                +"Oh, hello there"
            }
        }
        goto(TakingOrder)
    }

}

