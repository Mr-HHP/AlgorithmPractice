package other.od200;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Mr.黄
 * @description 符号运算
 * @since 2024/7/17 15:59
 **/
public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        try {
            System.out.println(calculate(expression));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Fraction calculate(String expression) {
        Stack<Fraction> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;
        while (i < expression.length()) {
            char charAt = expression.charAt(i);
            if (Character.isWhitespace(charAt)) {
                i++;
                continue;
            }
            if (Character.isDigit(charAt)) {
                int val = 0;
                while (i < expression.length() && Character.isDigit(charAt)) {
                    val = val * 10 + (charAt - '0');
                    i++;
                }
                values.push(new Fraction(val, 1));
                i--;
            } else if (charAt == '(') {
                operators.push(charAt);
            } else if (charAt == ')') {
                while (operators.peek() != '(') {
                    Fraction fraction1 = values.pop();
                    Fraction fraction2 = values.pop();
                    char op = operators.pop();
                    values.push(applyOp(fraction1, fraction2, op));
                }
                operators.pop();
            } else {
                while (!operators.isEmpty() && priority(operators.peek()) >= priority(charAt)) {
                    Fraction fraction1 = values.pop();
                    Fraction fraction2 = values.pop();
                    char op = operators.pop();
                    values.push(applyOp(fraction1, fraction2, op));
                }
                operators.push(charAt);
            }
            i++;
        }
        while (!operators.isEmpty()) {
            values.push(applyOp(values.pop(), values.pop(), operators.pop()));
        }
        return values.peek();
    }

    public static Fraction applyOp(Fraction fraction1, Fraction fraction2, char operator) {
        if (operator == '+') {
            return fraction1.add(fraction2);
        } else if (operator == '-') {
            return fraction1.subtraction(fraction2);
        } else if (operator == '*') {
            return fraction1.multiplication(fraction2);
        } else if (operator == '/') {
            return fraction1.divisionMethod(fraction2);
        } else {
            throw new RuntimeException("");
        }
    }

    public static int priority(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    public static class Fraction {
        // 被除数 分子
        int numerator;
        // 除数 分母
        int denominator;
        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            if (denominator == 0) {
                throw new RuntimeException("ERROR");
            }
            simplify();
        }

        public void simplify() {
            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;
        }

        public static int gcd(int numerator, int denominator) {
            while (denominator != 0) {
                int t = denominator;
                denominator = numerator % denominator;
                numerator = t;
            }
            return numerator;
        }

        public Fraction add(Fraction fraction) {
            return new Fraction(numerator * fraction.denominator + fraction.numerator * denominator, denominator * fraction.denominator);
        }
        public Fraction subtraction(Fraction fraction) {
            return new Fraction(numerator * fraction.denominator - fraction.numerator * denominator, denominator * fraction.denominator);
        }
        public Fraction multiplication(Fraction fraction) {
            return new Fraction(numerator * fraction.numerator, denominator * fraction.denominator);
        }
        public Fraction divisionMethod(Fraction fraction) {
            if (fraction.numerator == 0) {
                throw new RuntimeException("ERROR");
            }
            return new Fraction(numerator * fraction.denominator, denominator * fraction.numerator);
        }

        @Override
        public String toString() {
            if (denominator == 1) {
                return String.valueOf(numerator);
            } else {
                return numerator + "/" + denominator;
            }
        }
    }
}
