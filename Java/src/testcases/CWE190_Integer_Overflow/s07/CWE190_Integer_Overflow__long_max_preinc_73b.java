/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__long_max_preinc_73b.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-73b.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: max Set data to the max value for long
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: increment
 *    GoodSink: Ensure there will not be an overflow before incrementing data
 *    BadSink : Increment data, which can cause an overflow
 * Flow Variant: 73 Data flow: data passed in a LinkedList from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow.s07;
import testcasesupport.*;
import java.util.LinkedList;

import javax.servlet.http.*;

public class CWE190_Integer_Overflow__long_max_preinc_73b
{
    public void badSink(LinkedList<Long> dataLinkedList ) throws Throwable
    {
        long data = dataLinkedList.remove(2);

        /* POTENTIAL FLAW: if data == Long.MAX_VALUE, this will overflow */
        long result = (long)(++data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use GoodSource and BadSink */
    public void goodG2BSink(LinkedList<Long> dataLinkedList ) throws Throwable
    {
        long data = dataLinkedList.remove(2);

        /* POTENTIAL FLAW: if data == Long.MAX_VALUE, this will overflow */
        long result = (long)(++data);

        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use BadSource and GoodSink */
    public void goodB2GSink(LinkedList<Long> dataLinkedList ) throws Throwable
    {
        long data = dataLinkedList.remove(2);

        /* FIX: Add a check to prevent an overflow from occurring */
        if (data < Long.MAX_VALUE)
        {
            long result = (long)(++data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too large to increment.");
        }

    }
}
