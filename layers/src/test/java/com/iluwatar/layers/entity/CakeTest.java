/*
*The MIT License
*Copyright © 2014-2021 Ilkka Seppälä
*
*Permission is hereby granted, free of charge, to any person obtaining a copy
*of this software and associated documentation files (the "Software"), to deal
*in the Software without restriction, including without limitation the rights
*to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
*copies of the Software, and to permit persons to whom the Software is
*furnished to do so, subject to the following conditions:
*
*The above copyright notice and this permission notice shall be included in
*all copies or substantial portions of the Software.
*
*THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
*IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
*FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
*AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
*LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
*OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
*THE SOFTWARE.
*/

/*
 * The MIT License
 * Copyright © 2014-2021 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.iluwatar.layers.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * Date: 12/15/15 - 8:02 PM
 *
 * @author Jeroen Meulemeester
 */
public class CakeTest {

  @Test
  void testSetId() {
    final var cake = new Cake();
    assertNull(cake.getId());

    final var expectedId = 1234L;
    cake.setId(expectedId);
    assertEquals(expectedId, cake.getId());
  }

  @Test
  void testSetTopping() {
    final var cake = new Cake();
    assertNull(cake.getTopping());

    final var expectedTopping = new CakeTopping("DummyTopping", 1000);
    cake.setTopping(expectedTopping);
    assertEquals(expectedTopping, cake.getTopping());
  }

  @Test
  void testSetLayers() {
    final var cake = new Cake();
    assertNotNull(cake.getLayers());
    assertTrue(cake.getLayers().isEmpty());

    final var expectedLayers = Set.of(
        new CakeLayer("layer1", 1000),
        new CakeLayer("layer2", 2000),
        new CakeLayer("layer3", 3000));
    cake.setLayers(expectedLayers);
    assertEquals(expectedLayers, cake.getLayers());
  }

  @Test
  void testAddLayer() {
    final var cake = new Cake();
    assertNotNull(cake.getLayers());
    assertTrue(cake.getLayers().isEmpty());

    final Set<CakeLayer> initialLayers = new HashSet<>();
    initialLayers.add(new CakeLayer("layer1", 1000));
    initialLayers.add(new CakeLayer("layer2", 2000));

    cake.setLayers(initialLayers);
    assertEquals(initialLayers, cake.getLayers());

    final var newLayer = new CakeLayer("layer3", 3000);
    cake.addLayer(newLayer);

    final Set<CakeLayer> expectedLayers = new HashSet<>();
    expectedLayers.addAll(initialLayers);
    expectedLayers.addAll(initialLayers);
    expectedLayers.add(newLayer);
    assertEquals(expectedLayers, cake.getLayers());
  }

  @Test
  void testToString() {
    final var topping = new CakeTopping("topping", 20);
    topping.setId(2345L);

    final var layer = new CakeLayer("layer", 100);
    layer.setId(3456L);

    final var cake = new Cake();
    cake.setId(1234L);
    cake.setTopping(topping);
    cake.addLayer(layer);

    final var expected = "id=1234 topping=id=2345 name=topping calories=20 "
        + "layers=[id=3456 name=layer calories=100]";
    assertEquals(expected, cake.toString());

  }

}
