//package BuildersSpec
//
//import builders.authorizes.BuildAuths
//import org.scalatest.FunSuite
//
//class BuildAuthsSpec extends FunSuite {
//  test("random amount of auths is generated") {
//    val auths1 = BuildAuths.any()
//    val auths2 = BuildAuths.any()
//    val auths3 = BuildAuths.any()
//
//
//    assert(auths1.count() > 0)
//    assert(auths2.count() > 0)
//    assert(auths3.count() > 0)
//
//    assert(auths1.count() !== auths2.count() !== auths3.count() )
//  }
//}
