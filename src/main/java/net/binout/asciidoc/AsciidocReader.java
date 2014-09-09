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

import org.apache.commons.lang.StringUtils;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.ast.ContentPart;
import org.asciidoctor.ast.DocumentHeader;
import org.asciidoctor.ast.StructuredDocument;

import java.io.File;
import java.util.Collections;

public class AsciidocReader {

    public static void main(String[] args) {
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();

        // Read the document header : title for example
        DocumentHeader documentHeader = asciidoctor.readDocumentHeader(getJugSummerCampDoc());
        System.out.println(documentHeader.getDocumentTitle().getMain());

        // Read the document structure
        StructuredDocument document = asciidoctor.readDocumentStructure(getJugSummerCampDoc(), Collections.<String, Object>emptyMap());

        // Find the part with title "Speakers"
        ContentPart speakers = document.getParts().stream().filter(p -> "Speakers".equals(p.getTitle())).findFirst().get();
        // Count the number of speakers
        System.out.println(StringUtils.countMatches(speakers.getContent(), "sect2") + " speakers");
    }

    private static File getJugSummerCampDoc() {
        return new File(Thread.currentThread().getContextClassLoader().getResource("jugsummercamp.adoc").getFile());
    }
}
