import java.util.function.BiFunction;
import java.util.function.Consumer;

class BinaryNode<T> {
    T value;
    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode(T value) {
        this.value = value;
    }
    public BinaryNode(BinaryNode<T> node) {
        this.value = node.value;
        if (node.left != null) {
            this.left = new BinaryNode<>(node.left);
        }
        if (node.right != null) {
            this.right = new BinaryNode<>(node.right);
        }
    }


    public int numbel() {
        if (this == null) {
            return 0;
        } else {
            return 1 + (this.left == null ? 0 : this.left.numbel()) + (this.right == null ? 0 : this.right.numbel());
        }
    }

    public int numbl() {
        if (this == null) {
            return 0;
        } else {
            return (this.left == null ? 0 : this.left.numbl()) + (this.right == null ? 0 : this.right.numbl()) + 1;
        }
    }

    public int height() {
        if (this == null) {
            return -1;
        } else {
            return Math.max((this.left == null ? -1 : this.left.height()), (this.right == null ? -1 : this.right.height())) + 1;
        }
    }

    public boolean empty() {
        return this == null || (this.left == null && this.right == null);
    }

    public void swap() {
        if (this != null && !empty()) {
            BinaryNode<T> temp = this.left;
            this.left = this.right;
            this.right = temp;

            if (this.left != null) {
                this.left.swap();
            }

            if (this.right != null) {
                this.right.swap();
            }
        }
    }

    public boolean include(T value) {
        if (this == null) {
            return false;
        } else if (value.equals(this.value)) {
            return true;
        } else if (((Comparable<T>) value).compareTo(this.value) < 0) {
            return left != null && left.include(value);
        } else {
            return right != null && right.include(value);
        }
    }


    public void exclude(T value) {
        if (this.value == null) {
            return;
        }
        if (this.value.equals(value)) {
            this.value = null;
            return;
        }
        if (this.left != null) {
            this.left.exclude(value);
        }
        if (this.right != null) {
            this.right.exclude(value);
        }
    }

    public boolean find(T value) {
        if (this.value == null) {
            return false;
        }
        if (this.value.equals(value)) {
            return true;
        }
        boolean found = false;
        if (this.left != null) {
            found = this.left.find(value);
        }
        if (!found && this.right != null) {
            found = this.right.find(value);
        }
        return found;
    }

    public int accumulate(int initialValue, BiFunction<Integer, T, Integer> accumulator) {
        int result = initialValue;
        if (this.value != null) {
            result = accumulator.apply(result, this.value);
        }
        if (this.left != null) {
            result = this.left.accumulate(result, accumulator);
        }
        if (this.right != null) {
            result = this.right.accumulate(result, accumulator);
        }
        return result;
    }


    public void for_each(Consumer<T> consumer) {
        if (this.value != null) {
            consumer.accept(this.value);
        }
        if (this.left != null) {
            this.left.for_each(consumer);
        }
        if (this.right != null) {
            this.right.for_each(consumer);
        }
    }
}