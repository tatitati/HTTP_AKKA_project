package app.domain

class Scope(val firstname: Boolean, val surname: Boolean, val email: Boolean) // Test edge case: what happens when someone creates an scope with everything forbidden????, it should throw an exception for sure
