#!/bin/bash

mvn clean package -Pslide

 ./deck2pdf/bin/deck2pdf ./target/generated-slides/asciidoctor-quickie.html ./target/generated-slides/asciidoctor-quickie.pdf
