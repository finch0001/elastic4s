package com.sksamuel.elastic4s.requests.nodes

import com.sksamuel.elastic4s.testkit.DockerTests
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class NodesInfoHttpTest extends AnyWordSpec with Matchers with DockerTests {

  "node info request" should {
    "return node information" in {
      val nodes = client.execute {
        nodeInfo()
      }.await.result

      nodes.clusterName should be("docker-cluster")
      nodes.nodes.values.toSeq.head.os.availableProcessors > 0 shouldBe true
    }
  }
}
