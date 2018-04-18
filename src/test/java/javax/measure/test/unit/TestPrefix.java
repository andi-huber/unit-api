/*
 * Units of Measurement API
 * Copyright (c) 2014-2018, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385 nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package javax.measure.test.unit;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import javax.measure.spi.Prefix;

/**
 * <p>
 * This class provides support for some prefixes used in the metric system (decimal multiples and submultiples of units). For example:
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.0, 2018-03-28
 * @since 2.0
 */
public enum TestPrefix implements Prefix {
	MEGA("M", 10, 6), //
	KILO("k", 10, 3);

	/**
	 * The symbol of this prefix, as returned by {@link #getSymbol}.
	 *
	 * @serial
	 * @see #getSymbol()
	 */
	private final String symbol;

	private final int base;
	private final int power;

	/**
	 * Creates a new prefix.
	 *
	 * @param symbol
	 *          the symbol of this prefix.
	 * @param base
	 *          part of the associated factor in base^power representation.
	 * @param power
	 *          part of the associated factor in base^power representation.
	 */
	private TestPrefix(String symbol, int base, int power) {
		this.symbol = symbol;
		this.base = base;
		this.power = power;
	}

	/**
	 * Returns the symbol of this prefix.
	 *
	 * @return this prefix symbol, not {@code null}.
	 */
	@Override
	public String getSymbol() {
		return symbol;
	}

	/**
	 * Base part of the associated factor in base^power representation.
	 */
	@Override
	public int getBase() {
		return base;
	}
	
	/**
	 * Power part of the associated factor in base^power representation.
	 */
	@Override
	public int getPower() {
		return power;
	}

	public static Set<Prefix> prefixes() {
		return Collections.<Prefix> unmodifiableSet(EnumSet.allOf(TestPrefix.class));
	}
}
