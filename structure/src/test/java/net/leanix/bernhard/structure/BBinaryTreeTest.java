package net.leanix.bernhard.structure;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BBinaryTreeTest {

    BBinaryTree b;

    @Before
    public void setup() {
        b = new BBinaryTree();
    }

    @Test
    public void breadthFirst_emptyTree_shouldReturnEmptyList() {
        // given

        // when
        List<String> result = b.breadthFirst();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void breadthFirst_onlyRootNode_shouldReturnRoot() {
        // given
        BBinaryTree.Node root = new BBinaryTree.Node("Root");
        b.setRoot(root);

        // when
        List<String> result = b.breadthFirst();

        // then
        assertThat(result).containsExactly("Root");
    }

    @Test
    public void breadthFirst_rootWithOneChild_shouldReturnRootAndThenChild() {
        // given
        BBinaryTree.Node root = new BBinaryTree.Node("Root");
        b.setRoot(root);
        root.setLeft(new BBinaryTree.Node("Root/Left"));

        // when
        List<String> result = b.breadthFirst();

        // then
        assertThat(result).containsExactly("Root", "Root/Left");
    }

    @Test
    public void breadthFirst_rootWithTwoChildren_shouldReturnRootAndThenLeftChildAndThenRightChild() {
        // given
        BBinaryTree.Node root = new BBinaryTree.Node("Root");
        b.setRoot(root);
        root.setLeft(new BBinaryTree.Node("Root/Left"));
        root.setRight(new BBinaryTree.Node("Root/Right"));

        // when
        List<String> result = b.breadthFirst();

        // then
        assertThat(result).containsExactly("Root", "Root/Left", "Root/Right");
    }

    @Test
    public void breadthFirst_tree1_shouldReturnCorrectTraversal() {
        // given
        BBinaryTree.Node root = new BBinaryTree.Node("Root");
        b.setRoot(root);
        BBinaryTree.Node left = new BBinaryTree.Node("Root/Left");
        root.setLeft(left);
        root.setRight(new BBinaryTree.Node("Root/Right"));
        left.setLeft(new BBinaryTree.Node("Root/Left/Left"));

        // when
        List<String> result = b.breadthFirst();

        // then
        assertThat(result).containsExactly("Root", "Root/Left", "Root/Right", "Root/Left/Left");
    }
}