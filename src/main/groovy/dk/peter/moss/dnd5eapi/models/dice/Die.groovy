package dk.peter.moss.dnd5eapi.models.dice

abstract class Die {
    final int sides

    Die(int sides) {
        this.sides = sides
    }

    int roll() {
        return 1 + Math.floor(Math.random() * this.sides)
    }

    static final class D4 extends Die {
        D4() { super(4) }
    }

    static final class D6 extends Die {
        D6() { super(6) }
    }

    static final class D8 extends Die {
        D8() { super(8) }
    }

    static final class D10 extends Die {
        D10() { super(10) }
    }

    static final class D12 extends Die {
        D12() { super(12) }
    }

    static class D20 extends Die {
        D20() { super(20) }
    }
}
