/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.decoder;

/**
 * Format specific field decoder description.
 */
public interface FieldDecoder<T>
{
    /**
     * Default name. Each decoder type *must* have a default decoder as fallback.
     */
    String DEFAULT_FIELD_DECODER_NAME = "_default";

    /**
     * Returns the name of the row decoder to which this field decoder belongs.
     */
    String getRowDecoderName();

    /**
     * Returns the field decoder specific name.
     */
    String getFieldDecoderName();

    /**
     * Decode a value for the given column handle.
     *
     * @param value The raw value as generated by the row decoder.
     * @param columnHandle The column for which the value is decoded.
     * @return A {@link FieldValueProvider} instance which returns a captured value for this specific column.
     */
    FieldValueProvider decode(T value, DecoderColumnHandle columnHandle);
}
