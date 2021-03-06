/*
 This Java source file was generated by test-to-java.xsl
 and is a derived work from the source document.
 The source document contained the following notice:



 Copyright (c) 2001 World Wide Web Consortium,
 (Massachusetts Institute of Technology, Institut National de
 Recherche en Informatique et en Automatique, Keio University).  All
 Rights Reserved.  This program is distributed under the W3C's Software
 Intellectual Property License.  This program is distributed in the
 hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 PURPOSE.

 See W3C License http://www.w3.org/Consortium/Legal/ for more details.


 */

package tests.org.w3c.dom;

import dalvik.annotation.TestTargets;
import dalvik.annotation.TestLevel;
import dalvik.annotation.TestTargetNew;
import dalvik.annotation.TestTargetClass;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Attr;
import org.w3c.dom.Text;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NodeList;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.EntityReference;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.DOMException;

import javax.xml.parsers.DocumentBuilder;

/**
 * The "importNode(importedNode,deep)" method for a Document should import the
 * given importedNode into that Document. The importedNode is of type Attr. The
 * ownerElement is set to null. Specified flag is set to true. Children is
 * imported.
 *
 * Create a new attribute whose name is "elem:attr1" in a different document.
 * Create a child Text node with value "importedText" for the attribute node
 * above. Invoke method importNode(importedNode,deep) on this document with
 * importedNode being the newly created attribute. Method should return a node
 * whose name matches "elem:attr1" and a child node whose value equals
 * "importedText". The returned node should belong to this document whose
 * systemId is "staff.dtd"
 *
 * @author NIST
 * @author Mary Brady
 * @see <a
 *      href="http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode">http://www.w3.org/TR/DOM-Level-2-Core/core#Core-Document-importNode</a>
 */
@TestTargetClass(Document.class)
public final class ImportNode extends DOMTestCase {

    DOMDocumentBuilderFactory factory;

    DocumentBuilder builder;

    protected void setUp() throws Exception {
        super.setUp();
        try {
            factory = new DOMDocumentBuilderFactory(DOMDocumentBuilderFactory
                    .getConfiguration2());
            builder = factory.getBuilder();
        } catch (Exception e) {
            fail("Unexpected exception" + e.getMessage());
        }
    }

    protected void tearDown() throws Exception {
        factory = null;
        builder = null;
        super.tearDown();
    }

    /**
     * Runs the test case.
     *
     * @throws Throwable
     *             Any uncaught exception causes test to fail
     */
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Doesn't verify DOMException.",
        method = "importNode",
        args = {org.w3c.dom.Node.class, boolean.class}
    )
    public void _testImportNode1() throws Throwable {
        Document doc;
        Document aNewDoc;
        Attr newAttr;
        Text importedChild;
        Node aNode;
        Document ownerDocument;
        Element attrOwnerElement;
        DocumentType docType;
        String system;
        boolean specified;
        NodeList childList;
        String nodeName;
        Node child;
        String childValue;
        List<String> expectedResult = new ArrayList<String>();
        expectedResult.add("elem:attr1");
        expectedResult.add("importedText");

        doc = (Document) load("staffNS", builder);
        aNewDoc = (Document) load("staffNS", builder);
        newAttr = aNewDoc.createAttribute("elem:attr1");
        importedChild = aNewDoc.createTextNode("importedText");
        aNode = newAttr.appendChild(importedChild);
        aNode = doc.importNode(newAttr, false);
        ownerDocument = aNode.getOwnerDocument();
        docType = ownerDocument.getDoctype();
        system = docType.getSystemId();
        assertNotNull("aNode", aNode);
        assertURIEquals("systemId", null, null, null, "staffNS.dtd", null,
                null, null, null, system);
        attrOwnerElement = ((Attr) /* Node */aNode).getOwnerElement();
        assertNull("ownerElement", attrOwnerElement);
        specified = ((Attr) /* Node */aNode).getSpecified();
        assertTrue("specified", specified);
        childList = aNode.getChildNodes();
        assertEquals("childList", 1, childList.getLength());
        nodeName = aNode.getNodeName();
        assertEquals("nodeName", "elem:attr1", nodeName);
        child = aNode.getFirstChild();
        childValue = child.getNodeValue();
        assertEquals("childValue", "importedText", childValue);
    }
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Doesn't verify DOMException.",
        method = "importNode",
        args = {org.w3c.dom.Node.class, boolean.class}
    )
    public void testImportNode2() throws Throwable {
        Document doc;
        Document aNewDoc;
        CDATASection cDataSec;
        Node aNode;
        Document ownerDocument;
        DocumentType docType;
        String system;
        String value;
        doc = (Document) load("staffNS", builder);
        aNewDoc = (Document) load("staffNS", builder);
        cDataSec = aNewDoc.createCDATASection("this is CDATASection data");
        aNode = doc.importNode(cDataSec, false);
        ownerDocument = aNode.getOwnerDocument();
        assertNotNull("ownerDocumentNotNull", ownerDocument);
        docType = ownerDocument.getDoctype();
        system = docType.getSystemId();
        assertURIEquals("dtdSystemId", null, null, null, "staffNS.dtd", null,
                null, null, null, system);
        value = aNode.getNodeValue();
        assertEquals("nodeValue", "this is CDATASection data", value);
    }
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Doesn't verify DOMException.",
        method = "importNode",
        args = {org.w3c.dom.Node.class, boolean.class}
    )
    public void testImportNode3() throws Throwable {
        Document doc;
        Document aNewDoc;
        Comment comment;
        Node aNode;
        Document ownerDocument;
        DocumentType docType;
        String system;
        String value;
        doc = (Document) load("staffNS", builder);
        aNewDoc = (Document) load("staffNS", builder);
        comment = aNewDoc.createComment("this is a comment");
        aNode = doc.importNode(comment, false);
        ownerDocument = aNode.getOwnerDocument();
        assertNotNull("ownerDocumentNotNull", ownerDocument);
        docType = ownerDocument.getDoctype();
        system = docType.getSystemId();
        assertURIEquals("systemId", null, null, null, "staffNS.dtd", null,
                null, null, null, system);
        value = aNode.getNodeValue();
        assertEquals("nodeValue", "this is a comment", value);
    }
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Doesn't verify DOMException.",
        method = "importNode",
        args = {org.w3c.dom.Node.class, boolean.class}
    )
    public void testImportNode4() throws Throwable {
        Document doc;
        Document aNewDoc;
        DocumentFragment docFrag;
        Comment comment;
        Node aNode;
        NodeList children;
        Node child;
        String childValue;
        doc = (Document) load("staff", builder);
        aNewDoc = (Document) load("staff", builder);
        docFrag = aNewDoc.createDocumentFragment();
        comment = aNewDoc.createComment("descendant1");
        aNode = docFrag.appendChild(comment);
        aNode = doc.importNode(docFrag, true);
        children = aNode.getChildNodes();
        assertEquals("throw_Size", 1, children.getLength());
        child = aNode.getFirstChild();
        childValue = child.getNodeValue();
        assertEquals("descendant1", "descendant1", childValue);
    }
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Doesn't verify DOMException.",
        method = "importNode",
        args = {org.w3c.dom.Node.class, boolean.class}
    )
    public void testImportNode5() throws Throwable {
        Document doc;
        Document aNewDoc;
        Element element;
        Node aNode;
        boolean hasChild;
        Document ownerDocument;
        DocumentType docType;
        String system;
        String name;
        NodeList addresses;
        doc = (Document) load("staffNS", builder);
        aNewDoc = (Document) load("staffNS", builder);
        addresses = aNewDoc.getElementsByTagName("emp:address");
        element = (Element) addresses.item(0);
        assertNotNull("empAddressNotNull", element);
        aNode = doc.importNode(element, false);
        hasChild = aNode.hasChildNodes();
        assertFalse("hasChild", hasChild);
        ownerDocument = aNode.getOwnerDocument();
        docType = ownerDocument.getDoctype();
        system = docType.getSystemId();
        assertURIEquals("dtdSystemId", null, null, null, "staffNS.dtd", null,
                null, null, null, system);
        name = aNode.getNodeName();
        assertEquals("nodeName", "emp:address", name);
    }
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Doesn't verify DOMException.",
        method = "importNode",
        args = {org.w3c.dom.Node.class, boolean.class}
    )
    public void testImportNode6() throws Throwable {
        Document doc;
        Document aNewDoc;
        Element element;
        Node aNode;
        boolean hasChild;
        String name;
        Node child;
        String value;
        NodeList addresses;
        doc = (Document) load("staffNS", builder);
        aNewDoc = (Document) load("staffNS", builder);
        addresses = aNewDoc.getElementsByTagName("emp:address");
        element = (Element) addresses.item(0);
        assertNotNull("empAddressNotNull", element);
        aNode = doc.importNode(element, true);
        hasChild = aNode.hasChildNodes();
        assertTrue("throw_True", hasChild);
        name = aNode.getNodeName();
        assertEquals("nodeName", "emp:address", name);
        child = aNode.getFirstChild();
        value = child.getNodeValue();
        assertEquals("nodeValue", "27 South Road. Dallas, texas 98556", value);
    }

// Assumes validation.
//    public void testImportNode7() throws Throwable {
//        Document doc;
//        Document aNewDoc;
//        Element element;
//        Node aNode;
//        NamedNodeMap attributes;
//        String name;
//        Node attr;
//        String lname;
//        String namespaceURI = "http://www.nist.gov";
//        String qualifiedName = "emp:employee";
//        doc = (Document) load("staffNS", builder);
//        aNewDoc = (Document) load("staff", builder);
//        element = aNewDoc.createElementNS(namespaceURI, qualifiedName);
//        aNode = doc.importNode(element, false);
//        attributes = aNode.getAttributes();
//        assertEquals("throw_Size", 1, attributes.getLength());
//        name = aNode.getNodeName();
//        assertEquals("nodeName", "emp:employee", name);
//        attr = attributes.item(0);
//        lname = attr.getLocalName();
//        assertEquals("lname", "defaultAttr", lname);
//    }
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Doesn't verify DOMException.",
        method = "importNode",
        args = {org.w3c.dom.Node.class, boolean.class}
    )
    public void testImportNode8() throws Throwable {
        Document doc;
        Document aNewDoc;
        DocumentFragment docFrag;
        Node aNode;
        boolean hasChild;
        Document ownerDocument;
        DocumentType docType;
        String system;
        doc = (Document) load("staffNS", builder);
        aNewDoc = (Document) load("staffNS", builder);
        docFrag = aNewDoc.createDocumentFragment();
        aNode = doc.importNode(docFrag, false);
        hasChild = aNode.hasChildNodes();
        assertFalse("hasChild", hasChild);
        ownerDocument = aNode.getOwnerDocument();
        docType = ownerDocument.getDoctype();
        system = docType.getSystemId();
        assertURIEquals("system", null, null, null, "staffNS.dtd", null, null,
                null, null, system);
    }

// Assumes validation.
//    public void testImportNode9() throws Throwable {
//        Document doc;
//        Document aNewDoc;
//
//        NamedNodeMap entityList;
//        Entity entity2;
//        Entity entity1;
//        Document ownerDocument;
//        DocumentType docType;
//        String system;
//        String entityName;
//        String publicVal;
//        String notationName;
//        doc = (Document) load("staffNS", builder);
//        aNewDoc = (Document) load("staffNS", builder);
//        docType = aNewDoc.getDoctype();
//        entityList = docType.getEntities();
//        assertNotNull("entitiesNotNull", entityList);
//        entity2 = (Entity) entityList.getNamedItem("ent6");
//        entity1 = (Entity) doc.importNode(entity2, false);
//        ownerDocument = entity1.getOwnerDocument();
//        docType = ownerDocument.getDoctype();
//        system = docType.getSystemId();
//        assertURIEquals("dtdSystemId", null, null, null, "staffNS.dtd", null,
//                null, null, null, system);
//        entityName = entity1.getNodeName();
//        assertEquals("entityName", "ent6", entityName);
//        publicVal = entity1.getPublicId();
//        assertEquals("entityPublicId", "uri", publicVal);
//        system = entity1.getSystemId();
//        assertURIEquals("entitySystemId", null, null, null, "file", null, null,
//                null, null, system);
//        notationName = entity1.getNotationName();
//        assertEquals("notationName", "notation2", notationName);
//    }
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Doesn't verify DOMException.",
        method = "importNode",
        args = {org.w3c.dom.Node.class, boolean.class}
    )
    public void testImportNode10() throws Throwable {
        Document doc;
        Document aNewDoc;
        EntityReference entRef;
        Node aNode;
        Document ownerDocument;
        DocumentType docType;
        String system;
        String name;
        doc = (Document) load("staffNS", builder);
        aNewDoc = (Document) load("staffNS", builder);
        entRef = aNewDoc.createEntityReference("entRef1");
        assertNotNull("createdEntRefNotNull", entRef);
        entRef.setNodeValue("entRef1Value");
        aNode = doc.importNode(entRef, false);
        ownerDocument = aNode.getOwnerDocument();
        docType = ownerDocument.getDoctype();
        system = docType.getSystemId();
        assertURIEquals("systemId", null, null, null, "staffNS.dtd", null,
                null, null, null, system);
        name = aNode.getNodeName();
        assertEquals("nodeName", "entRef1", name);
    }

// Assumes validation
//    public void testImportNode11() throws Throwable {
//        Document doc;
//        Document aNewDoc;
//        EntityReference entRef;
//        Node aNode;
//        String name;
//        Node child;
//        String childValue;
//        doc = (Document) load("staff", builder);
//        aNewDoc = (Document) load("staff", builder);
//        entRef = aNewDoc.createEntityReference("ent3");
//        assertNotNull("createdEntRefNotNull", entRef);
//        aNode = doc.importNode(entRef, true);
//        name = aNode.getNodeName();
//        assertEquals("entityName", "ent3", name);
//        child = aNode.getFirstChild();
//        assertNotNull("child", child);
//        childValue = child.getNodeValue();
//        assertEquals("childValue", "Texas", childValue);
//    }

// Assumes validation.
//    public void testImportNode12() throws Throwable {
//        Document doc;
//        Document aNewDoc;
//        DocumentType doc1Type;
//        NamedNodeMap entityList;
//        Entity entity2;
//        Entity entity1;
//        Document ownerDocument;
//        DocumentType docType;
//        String system;
//        String entityName;
//        Node child;
//        String childName;
//        doc = (Document) load("staffNS", builder);
//        aNewDoc = (Document) load("staffNS", builder);
//        doc1Type = aNewDoc.getDoctype();
//        entityList = doc1Type.getEntities();
//        assertNotNull("entitiesNotNull", entityList);
//        entity2 = (Entity) entityList.getNamedItem("ent4");
//        entity1 = (Entity) doc.importNode(entity2, true);
//        ownerDocument = entity1.getOwnerDocument();
//        docType = ownerDocument.getDoctype();
//        system = docType.getSystemId();
//        assertURIEquals("systemId", null, null, null, "staffNS.dtd", null,
//                null, null, null, system);
//        entityName = entity1.getNodeName();
//        assertEquals("entityName", "ent4", entityName);
//        child = entity1.getFirstChild();
//        assertNotNull("notnull", child);
//        childName = child.getNodeName();
//        assertEquals("childName", "entElement1", childName);
//    }

// Assumes validation
//    public void testImportNode13() throws Throwable {
//        Document doc;
//        Document aNewDoc;
//        DocumentType doc1Type;
//        NamedNodeMap notationList;
//        Notation notation;
//        Notation aNode;
//        Document ownerDocument;
//        DocumentType docType;
//        String system;
//        String publicVal;
//        doc = (Document) load("staffNS", builder);
//        aNewDoc = (Document) load("staffNS", builder);
//        doc1Type = aNewDoc.getDoctype();
//        notationList = doc1Type.getNotations();
//        assertNotNull("notationsNotNull", notationList);
//        notation = (Notation) notationList.getNamedItem("notation1");
//        aNode = (Notation) doc.importNode(notation, false);
//        ownerDocument = aNode.getOwnerDocument();
//        docType = ownerDocument.getDoctype();
//        system = docType.getSystemId();
//        assertURIEquals("systemId", null, null, null, "staffNS.dtd", null,
//                null, null, null, system);
//        publicVal = aNode.getPublicId();
//        assertEquals("publicId", "notation1File", publicVal);
//        system = aNode.getSystemId();
//        assertNull("notationSystemId", system);
//    }
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Doesn't verify DOMException.",
        method = "importNode",
        args = {org.w3c.dom.Node.class, boolean.class}
    )
    public void testImportNode14() throws Throwable {
        Document doc;
        Document aNewDoc;
        ProcessingInstruction pi;
        ProcessingInstruction aNode;
        Document ownerDocument;
        DocumentType docType;
        String system;
        String target;
        String data;

        doc = (Document) load("staffNS", builder);
        aNewDoc = (Document) load("staffNS", builder);
        pi = aNewDoc.createProcessingInstruction("target1", "data1");
        aNode = (ProcessingInstruction) doc.importNode(pi, false);
        ownerDocument = aNode.getOwnerDocument();
        assertNotNull("ownerDocumentNotNull", ownerDocument);
        docType = ownerDocument.getDoctype();
        system = docType.getSystemId();
        assertURIEquals("systemId", null, null, null, "staffNS.dtd", null,
                null, null, null, system);
        target = aNode.getTarget();
        assertEquals("piTarget", "target1", target);
        data = aNode.getData();
        assertEquals("piData", "data1", data);
    }
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Doesn't verify DOMException.",
        method = "importNode",
        args = {org.w3c.dom.Node.class, boolean.class}
    )
    public void testImportNode15() throws Throwable {
        Document doc;
        Document aNewDoc;
        Text text;
        Node aNode;
        Document ownerDocument;
        DocumentType docType;
        String system;
        String value;
        doc = (Document) load("staffNS", builder);
        aNewDoc = (Document) load("staffNS", builder);
        text = aNewDoc.createTextNode("this is text data");
        aNode = doc.importNode(text, false);
        ownerDocument = aNode.getOwnerDocument();
        assertNotNull("ownerDocumentNotNull", ownerDocument);
        docType = ownerDocument.getDoctype();
        system = docType.getSystemId();
        assertURIEquals("systemId", null, null, null, "staffNS.dtd", null,
                null, null, null, system);
        value = aNode.getNodeValue();
        assertEquals("nodeValue", "this is text data", value);
    }
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Verifies that importNode method throws DOMException with NOT_SUPPORTED_ERR code.",
        method = "importNode",
        args = {org.w3c.dom.Node.class, boolean.class}
    )
    public void testImportNode16() throws Throwable {
        Document doc;
        Document anotherDoc;
        DocumentType docType;

        doc = (Document) load("staffNS", builder);
        anotherDoc = (Document) load("staffNS", builder);
        docType = anotherDoc.getDoctype();

        {
            boolean success = false;
            try {
                doc.importNode(docType, false);
            } catch (DOMException ex) {
                success = (ex.code == DOMException.NOT_SUPPORTED_ERR);
            }
            assertTrue("throw_NOT_SUPPORTED_ERR", success);
        }
    }
    @TestTargetNew(
        level = TestLevel.PARTIAL_COMPLETE,
        notes = "Verifies that importNode method throws DOMException with NOT_SUPPORTED_ERR code.",
        method = "importNode",
        args = {org.w3c.dom.Node.class, boolean.class}
    )
    public void testImportNode17() throws Throwable {
        Document doc;
        Document anotherDoc;

        doc = (Document) load("staffNS", builder);
        anotherDoc = (Document) load("staffNS", builder);

        {
            boolean success = false;
            try {
                doc.importNode(anotherDoc, false);
            } catch (DOMException ex) {
                success = (ex.code == DOMException.NOT_SUPPORTED_ERR);
            }
            assertTrue("throw_NOT_SUPPORTED_ERR", success);
        }
    }
}
