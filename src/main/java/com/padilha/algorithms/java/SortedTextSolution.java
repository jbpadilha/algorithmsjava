package com.padilha.algorithms.java;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Document {
    String name;
    String description;
    String createdBy;
    String lastModifiedBy;
    Long sizeInBytes;
    Long createdTime;
    Long modifiedTime;

    /**
     * Method to return the size in Bytes converted String
     * @param size
     * @return
     */
    public static String convertSize(long size) {
        String result = String.valueOf(size);
        if (size > 1024 && size < 1024 * 1024) {
            result = String.valueOf(size / 1024) + " kb";
        } else if (size >= 1024 * 1024 && size < 1024 * 1024 * 1024) {
            result = String.valueOf(size / 1024 / 1024) + " mb";
        } else if (size >= 1024 * 1024 * 1024) {
            result = String.valueOf(size / 1024 / 1024 / 1024) + " gb";
        } else {
            result = result + " B";
        }
        return result;
    }

    /**
     * Prints a report of the list of documents in the following format:
     *
     * Group by document.createdBy
     * Sort the groups using document.createdBy ascending, case insensitive
     *      Sort each sub list of documents by document.createdTime ascending
     * Format the output of document.size to be a more friendly format. Ex.  50 mb, 900 k, 342 bytes, etc...
     * Format the dates using the format: yyyy-MM-dd
     * Format the output of document.description such that
     *  - no more than the first 25 characters of the description are displayed
     *  - don't truncate any words unless the first word is longer than 25 characters
     *  - display "..." at the end of the description to indicate that it has been truncated
     *  (these three characters do not count as part of the 25 character limit)
     *
     * Example:
     * Andy Andrews
     *      "Bobby Timmons Biography","An exhaustive look at the ...",233 mb,2013-05-09,2013-05-14
     *      "Apple Sauce","Study of apple sauces.”,87 gb,2013-05-10,2013-05-10
     *      "Zed","All matters, A to Zed”,924 k,2013-05-12,2013-05-12
     * Janet Smith
     *      "Xray","How the Xray shows your ...",48 mb,2010-10-22,2010-12-02
     *      "Computers","Inventory list of ...",423 bytes,2013-03-01,2013-02-17
     *
     *
     * @param documents not null
     */

    public void printDocumentsReport(List<Document> documents) {
        // First - Sort by CreatedBY
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Map<String, List<Document>> authorsGrouped = documents.stream().sorted(Comparator.comparing(doc -> doc.createdBy, String.CASE_INSENSITIVE_ORDER)).collect(Collectors.groupingBy(d -> d.createdBy));
        authorsGrouped.forEach((key,value) -> {
            System.out.println(key);
            value.stream().sorted(Comparator.comparing(doc -> doc.createdTime)).forEach(doc -> {
                LocalDateTime createdIn =
                        LocalDateTime.ofInstant(Instant.ofEpochMilli(doc.createdTime),
                                TimeZone.getDefault().toZoneId());
                LocalDateTime modifiedOn =
                        LocalDateTime.ofInstant(Instant.ofEpochMilli(doc.modifiedTime),
                                TimeZone.getDefault().toZoneId());
                String newDescription = doc.description;
                if (newDescription.length() > 25) {
                    newDescription = newDescription.substring(0, 25) + " ...";
                }
                System.out.println("     \""+ doc.name + "\", \""+newDescription+"\", "+convertSize(doc.sizeInBytes)+ ", "+createdIn.format(formatter)+ ", "+ modifiedOn.format(formatter));
            });
        });
    }
}

public class SortedTextSolution {

    public static void main(String[] args) {
        long KILOBYTE = 1024L;
        long MEGABYTE = 1024L * 1024L;
        long GIGABYTE = 1024L * 1024L * 1024L;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ArrayList<Document> docs = new ArrayList<>();
        // Test 1
        Document doc1 = new Document();
        doc1.createdBy = "Andy Andrews";
        doc1.name = "Bobby Timmons Biography";
        doc1.description = "An exhaustive look at the document test test test";
        doc1.sizeInBytes = 233L * MEGABYTE;
        LocalDate dateA = LocalDate.parse("2013-05-09", formatter);
        Timestamp timestampA = Timestamp.valueOf(dateA.atStartOfDay());
        doc1.createdTime = timestampA.getTime();
        LocalDate dateB = LocalDate.parse("2013-05-14", formatter);
        Timestamp timestampB = Timestamp.valueOf(dateB.atStartOfDay());
        doc1.modifiedTime = timestampB.getTime();

        // Test 2
        Document doc2 = new Document();
        doc2.createdBy = "Andy Andrews";
        doc2.name = "Zed";
        doc2.description = "All matters, A to Zed";
        doc2.sizeInBytes = 87L * GIGABYTE;
        LocalDate dateA2 = LocalDate.parse("2013-05-10", formatter);
        Timestamp timestampA2 = Timestamp.valueOf(dateA2.atStartOfDay());
        doc2.createdTime = timestampA2.getTime();
        LocalDate dateB2 = LocalDate.parse("2013-05-10", formatter);
        Timestamp timestampB2 = Timestamp.valueOf(dateB2.atStartOfDay());
        doc2.modifiedTime = timestampB2.getTime();

        // Test 3
        Document doc3 = new Document();
        doc3.createdBy = "Andy Andrews";
        doc3.name = "Apple Sauce";
        doc3.description = "Study of apple sauces.";
        doc3.sizeInBytes = 924L * KILOBYTE;
        LocalDate dateA3 = LocalDate.parse("2013-05-10", formatter);
        Timestamp timestampA3 = Timestamp.valueOf(dateA3.atStartOfDay());
        doc3.createdTime = timestampA3.getTime();
        LocalDate dateB3 = LocalDate.parse("2013-05-10", formatter);
        Timestamp timestampB3 = Timestamp.valueOf(dateB3.atStartOfDay());
        doc3.modifiedTime = timestampB3.getTime();

        // Test 4
        Document doc4 = new Document();
        doc4.createdBy = "Janet Smith";
        doc4.name = "Xray";
        doc4.description = "How the Xray shows your test test test test test test";
        doc4.sizeInBytes = 48L * MEGABYTE;
        LocalDate dateA4 = LocalDate.parse("2010-10-22", formatter);
        Timestamp timestampA4 = Timestamp.valueOf(dateA4.atStartOfDay());
        doc4.createdTime = timestampA4.getTime();
        LocalDate dateB4 = LocalDate.parse("2010-12-02", formatter);
        Timestamp timestampB4 = Timestamp.valueOf(dateB4.atStartOfDay());
        doc4.modifiedTime = timestampB4.getTime();

        // Test 5
        Document doc5 = new Document();
        doc5.createdBy = "Janet Smith";
        doc5.name = "Computers";
        doc5.description = "Inventory list of  test test test test test test";
        doc5.sizeInBytes = 423L * KILOBYTE;
        LocalDate dateA5 = LocalDate.parse("2013-03-01", formatter);
        Timestamp timestampA5 = Timestamp.valueOf(dateA5.atStartOfDay());
        doc5.createdTime = timestampA5.getTime();
        LocalDate dateB5 = LocalDate.parse("2013-02-17", formatter);
        Timestamp timestampB5 = Timestamp.valueOf(dateB5.atStartOfDay());
        doc5.modifiedTime = timestampB5.getTime();

        docs.add(doc1);
        docs.add(doc2);
        docs.add(doc3);
        docs.add(doc4);
        docs.add(doc5);

        new Document().printDocumentsReport(docs);
    }
}
