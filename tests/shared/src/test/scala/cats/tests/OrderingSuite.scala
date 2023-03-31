/*
 * Copyright (c) 2015 Typelevel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cats.tests

import cats.{Contravariant, ContravariantMonoidal, ContravariantSemigroupal, Invariant, Semigroupal}
import cats.laws.discipline.arbitrary._
import cats.laws.discipline._
import cats.laws.discipline.eq._

class OrderingSuite extends CatsSuite {

  Invariant[Ordering]
  Contravariant[Ordering]
  Semigroupal[Ordering]
  ContravariantSemigroupal[Ordering]
  ContravariantMonoidal[Ordering]

  checkAll("Contravariant[Ordering]", ContravariantTests[Ordering].contravariant[MiniInt, Int, Boolean])
  checkAll("Semigroupal[Ordering]", SemigroupalTests[Ordering].semigroupal[MiniInt, Boolean, Boolean])
  checkAll("ContravariantMonoidal[Ordering]",
           ContravariantMonoidalTests[Ordering].contravariantMonoidal[MiniInt, Boolean, Boolean]
  )
  checkAll("ContravariantMonoidal[Ordering]", SerializableTests.serializable(ContravariantMonoidal[Ordering]))
  checkAll("Defer[Order]", DeferTests[Ordering].defer[MiniInt])
}
