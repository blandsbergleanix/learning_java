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

    /*
     ################ breadth-first ##############
    */

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

    @Test
    public void breadthFirst_complexTree_shouldReturnCorrectTraversal() {
        // given
        BBinaryTree.Node root = new BBinaryTree.Node("Root");
        b.setRoot(root);
        BBinaryTree.Node left = new BBinaryTree.Node("Root/Left");
        BBinaryTree.Node leftleft = new BBinaryTree.Node("Root/Left/Left");
        BBinaryTree.Node leftright = new BBinaryTree.Node("Root/Left/Right");
        BBinaryTree.Node right = new BBinaryTree.Node("Root/Right");
        BBinaryTree.Node rightleft = new BBinaryTree.Node("Root/Right/Left");
        BBinaryTree.Node rightleftleft = new BBinaryTree.Node("Root/Right/Left/Left");
        BBinaryTree.Node rightleftright = new BBinaryTree.Node("Root/Right/Left/Right");
        root.setLeft(left);
        left.setLeft(leftleft);
        left.setRight(leftright);
        root.setRight(right);
        right.setLeft(rightleft);
        rightleft.setLeft(rightleftleft);
        rightleft.setRight(rightleftright);
        rightleftleft.setLeft(new BBinaryTree.Node("Root/Right/Left/Left/Left"));
        rightleftright.setRight(new BBinaryTree.Node("Root/Right/Left/Right/Right"));

        // when
        List<String> result = b.breadthFirst();

        // then
        assertThat(result).containsExactly("Root", "Root/Left", "Root/Right", "Root/Left/Left", "Root/Left/Right", "Root/Right/Left", "Root/Right/Left/Left", "Root/Right/Left/Right", "Root/Right/Left/Left/Left", "Root/Right/Left/Right/Right");
    }

    /*
     ################ depth-first ##############
    */

    @Test
    public void depthFirst_emptyTree_shouldReturnEmptyList() {
        // given

        // when
        List<String> result = b.depthFirst();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    public void depthFirst_onlyRootNode_shouldReturnRoot() {
        // given
        BBinaryTree.Node root = new BBinaryTree.Node("Root");
        b.setRoot(root);

        // when
        List<String> result = b.depthFirst();

        // then
        assertThat(result).containsExactly("Root");
    }

    @Test
    public void depthFirst_rootWithOneChild_shouldReturnRootAndThenChild() {
        // given
        BBinaryTree.Node root = new BBinaryTree.Node("Root");
        b.setRoot(root);
        root.setLeft(new BBinaryTree.Node("Root/Left"));

        // when
        List<String> result = b.depthFirst();

        // then
        assertThat(result).containsExactly("Root", "Root/Left");
    }

    @Test
    public void depthFirst_rootWithTwoChildren_shouldReturnRootAndThenLeftChildAndThenRightChild() {
        // given
        BBinaryTree.Node root = new BBinaryTree.Node("Root");
        b.setRoot(root);
        root.setLeft(new BBinaryTree.Node("Root/Left"));
        root.setRight(new BBinaryTree.Node("Root/Right"));

        // when
        List<String> result = b.depthFirst();

        // then
        assertThat(result).containsExactly("Root", "Root/Left", "Root/Right");
    }

    @Test
    public void depthFirst_tree1_shouldReturnCorrectTraversal() {
        // given
        BBinaryTree.Node root = new BBinaryTree.Node("Root");
        b.setRoot(root);
        BBinaryTree.Node left = new BBinaryTree.Node("Root/Left");
        root.setLeft(left);
        root.setRight(new BBinaryTree.Node("Root/Right"));
        left.setLeft(new BBinaryTree.Node("Root/Left/Left"));

        // when
        List<String> result = b.depthFirst();

        // then
        assertThat(result).containsExactly("Root", "Root/Left", "Root/Left/Left", "Root/Right");
    }

    @Test
    public void depthFirst_complexTree_shouldReturnCorrectTraversal() {
        // given
        BBinaryTree.Node root = new BBinaryTree.Node("Root");
        b.setRoot(root);
        BBinaryTree.Node left = new BBinaryTree.Node("Root/Left");
        BBinaryTree.Node leftleft = new BBinaryTree.Node("Root/Left/Left");
        BBinaryTree.Node leftright = new BBinaryTree.Node("Root/Left/Right");
        BBinaryTree.Node right = new BBinaryTree.Node("Root/Right");
        BBinaryTree.Node rightleft = new BBinaryTree.Node("Root/Right/Left");
        BBinaryTree.Node rightleftleft = new BBinaryTree.Node("Root/Right/Left/Left");
        BBinaryTree.Node rightleftright = new BBinaryTree.Node("Root/Right/Left/Right");
        root.setLeft(left);
        left.setLeft(leftleft);
        left.setRight(leftright);
        root.setRight(right);
        right.setLeft(rightleft);
        rightleft.setLeft(rightleftleft);
        rightleft.setRight(rightleftright);
        rightleftleft.setLeft(new BBinaryTree.Node("Root/Right/Left/Left/Left"));
        rightleftright.setRight(new BBinaryTree.Node("Root/Right/Left/Right/Right"));

        // when
        List<String> result = b.depthFirst();

        // then
        assertThat(result).containsExactly("Root", "Root/Left", "Root/Left/Left", "Root/Left/Right", "Root/Right", "Root/Right/Left", "Root/Right/Left/Left", "Root/Right/Left/Left/Left", "Root/Right/Left/Right", "Root/Right/Left/Right/Right");
    }

    @Test
    public void infixFirst_complexTree_shouldReturnCorrectTraversal() {
        // given
        BBinaryTree.Node root = new BBinaryTree.Node("Root");
        b.setRoot(root);
        BBinaryTree.Node left = new BBinaryTree.Node("Root/Left");
        BBinaryTree.Node leftleft = new BBinaryTree.Node("Root/Left/Left");
        BBinaryTree.Node leftright = new BBinaryTree.Node("Root/Left/Right");
        BBinaryTree.Node right = new BBinaryTree.Node("Root/Right");
        BBinaryTree.Node rightleft = new BBinaryTree.Node("Root/Right/Left");
        BBinaryTree.Node rightleftleft = new BBinaryTree.Node("Root/Right/Left/Left");
        BBinaryTree.Node rightleftright = new BBinaryTree.Node("Root/Right/Left/Right");
        root.setLeft(left);
        left.setLeft(leftleft);
        left.setRight(leftright);
        root.setRight(right);
        right.setLeft(rightleft);
        rightleft.setLeft(rightleftleft);
        rightleft.setRight(rightleftright);
        rightleftleft.setLeft(new BBinaryTree.Node("Root/Right/Left/Left/Left"));
        rightleftright.setRight(new BBinaryTree.Node("Root/Right/Left/Right/Right"));

        // when
        List<String> result = b.infixFirst();

        // then
        assertThat(result).containsExactly("Root/Left/Left", "Root/Left", "Root/Left/Right", "Root", "Root/Right/Left/Left/Left", "Root/Right/Left/Left", "Root/Right/Left", "Root/Right/Left/Right","Root/Right/Left/Right/Right", "Root/Right");
    }

    @Test
    public void polishNotationFirst_complexTree_shouldReturnCorrectTraversal() {
        // given
        BBinaryTree.Node root = new BBinaryTree.Node("Root");
        b.setRoot(root);
        BBinaryTree.Node left = new BBinaryTree.Node("Root/Left");
        BBinaryTree.Node leftleft = new BBinaryTree.Node("Root/Left/Left");
        BBinaryTree.Node leftright = new BBinaryTree.Node("Root/Left/Right");
        BBinaryTree.Node right = new BBinaryTree.Node("Root/Right");
        BBinaryTree.Node rightleft = new BBinaryTree.Node("Root/Right/Left");
        BBinaryTree.Node rightleftleft = new BBinaryTree.Node("Root/Right/Left/Left");
        BBinaryTree.Node rightleftright = new BBinaryTree.Node("Root/Right/Left/Right");
        root.setLeft(left);
        left.setLeft(leftleft);
        left.setRight(leftright);
        root.setRight(right);
        right.setLeft(rightleft);
        rightleft.setLeft(rightleftleft);
        rightleft.setRight(rightleftright);
        rightleftleft.setLeft(new BBinaryTree.Node("Root/Right/Left/Left/Left"));
        rightleftright.setRight(new BBinaryTree.Node("Root/Right/Left/Right/Right"));

        // when
        List<String> result = b.polishNotationFirst();

        // then
        assertThat(result).containsExactly("Root/Left/Left", "Root/Left/Right", "Root/Left");
    }
}