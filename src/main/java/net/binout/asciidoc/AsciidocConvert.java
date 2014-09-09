/*
 * Copyright 2014 Benoît Prioux
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.binout.asciidoc;

import org.asciidoctor.*;

import java.io.File;

public class AsciidocConvert {

    public static void main(String[] args) {
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();

        // Set attributes as backend
        Attributes attributes = AttributesBuilder.attributes()
                .backend("html5")
                .get();

        // Set options as destDir
        Options options = OptionsBuilder.options()
                .attributes(attributes)
                .toDir(new File("target/generated-docs"))
                .mkDirs(true)
                .safe(SafeMode.SAFE)
                .get();

        // Convert adoc to html
        asciidoctor.convertFile(getJugSummerCampDoc(), options);
    }

    private static File getJugSummerCampDoc() {
        return new File(Thread.currentThread().getContextClassLoader().getResource("jugsummercamp.adoc").getFile());
    }
}
