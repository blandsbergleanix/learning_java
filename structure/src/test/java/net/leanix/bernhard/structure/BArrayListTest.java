package net.leanix.bernhard.structure;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BArrayListTest {

    private BArrayList l;

    @Before
    public void setup() {
        l = new BArrayList();
    }

    @Test
    public void size_emptyList_shouldReturnZero() {
        // given

        // when
        int size = l.size();

        // then
        assertThat(size).isEqualTo(0);
    }

    @Test
    public void size_oneElementInList_shouldReturnOne() {
        // given
        l.add("one");

        // when
        int size = l.size();

        // then
        assertThat(size).isEqualTo(1);
    }

    @Test
    public void size_deleteAfterAddElement_shouldReturnSize0() {
        // given
        l.add("one");
        l.deleteElement(0);

        // when
        int size = l.size();

        // then
        assertThat(size).isEqualTo(0);
    }

    @Test
    public void size_deleteFromEmptyList_shouldReturnSize0() {
        // given
        l.deleteElement(0);

        // when
        int size = l.size();

        // then
        assertThat(size).isEqualTo(0);
    }

    @Test
    public void size_deleteNonExistingElementInNonEmptyList_shouldReturnCorrectSize() {
        // given
        l.add("one");
        l.add("two");
        l.deleteElement(10);

        // when
        int size = l.size();

        // then
        assertThat(size).isEqualTo(2);
    }

    @Test
    public void get_first_shouldReturnFirst() {
        // given
        l.add("one");

        // when
        String element = l.get(0);

        // then
        assertThat(element).isEqualTo("one");
    }

    @Test
    public void get_second_shouldReturnSecond() {
        // given
        l.add("one");
        l.add("two");

        // when
        String element = l.get(1);

        // then
        assertThat(element).isEqualTo("two");
    }

    @Test
    public void get_twoElementsAndRetrieveThird_shouldReturnNull() {
        // given
        l.add("one");
        l.add("two");

        // when
        String element = l.get(2);

        // then
        assertThat(element).isNull();
    }

    @Test
    public void clear_emptyList() {
        // given
        l.add("one");

        // when
        l.clear();

        // then
        assertThat(l.size()).isEqualTo(0);
        assertThat(l.get(0)).isNull();
    }

    @Test
    public void deleteElement_removeSecondElement_getSecondElementShouldReturnThirdElement() {
        // given
        l.add("one");
        l.add("two");
        l.add("three");

        // when
        l.deleteElement(1);

        // then
        assertThat(l.get(1)).isEqualTo("three");
    }

    @Test
    public void deleteElement_removeFirstElement_getFirstElementShouldReturnSecondElement() {
        // given
        l.add("one");
        l.add("two");
        l.add("three");

        // when
        l.deleteElement(0);

        // then
        assertThat(l.get(0)).isEqualTo("two");
    }

    @Test
    public void deleteElement_removeLastElement_() {
        // given
        l.add("one");
        l.add("two");
        l.add("three");

        // when
        l.deleteElement(2);

        // then
        assertThat(l.get(2)).isNull();
    }

    @Test
    public void deleteElement_removeInvalidIndexElement_shouldDoNothing() {
        // given
        l.add("one");
        l.add("two");
        l.add("three");

        // when
        l.deleteElement(5);

        // then
        assertThat(l.get(0)).isEqualTo("one");
    }

    @Test
    public void addAll_arrayElementsShouldBeAddedToList() {
        // given
        String[] stringArray = new String[3];
        stringArray[0] = "alpha";
        stringArray[1] = "gamma";
        stringArray[2] = "delta";

        // when
        l.addAll(stringArray);

        // then
        assertThat(l.get(1)).isEqualTo("gamma");
    }

    @Test
    public void insert_insertElementInSecondPosition_getSecondElementShouldReturnInsertedElement() {
        // given
        l.add("one");
        l.add("two");
        l.add("three");

        // when
        l.insert(1, "beta");

        // then
        assertThat(l.get(0)).isEqualTo("one");
        assertThat(l.get(1)).isEqualTo("beta");
        assertThat(l.get(2)).isEqualTo("two");
    }

    @Test
    public void insert_insertElementInInvalidPosition_getElementAtThatPositionShouldNotDoAnything() {
        // given
        l.add("one");
        l.add("two");
        l.add("three");

        // when
        l.insert(0, "beta");

        // then
        assertThat(l.get(0)).isEqualTo("beta");
        assertThat(l.get(1)).isEqualTo("one");
    }

    @Test
    public void add_initializArrayWithZero() {
        // given
        l = new BArrayList(0);

        // when
        l.add("one");

        // then
        assertThat(l.get(0)).isEqualTo("one");
    }
}