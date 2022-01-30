package com.greatlearning.main;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Stack<Character> brackets = new Stack<Character>();
		boolean invalidExpression = false;

		System.out.println("Enter bracket expression");
		String bracketExpression = scan.next();

		for (int i = 0; i < bracketExpression.length(); i++) {
			if (bracketExpression.charAt(i) == '[' || bracketExpression.charAt(i) == '{'
					|| bracketExpression.charAt(i) == '(') {
				brackets.push(bracketExpression.charAt(i));
			} else if (bracketExpression.charAt(i) == ']' || bracketExpression.charAt(i) == '}'
					|| bracketExpression.charAt(i) == ')') {
				if (brackets.isEmpty()) {
					invalidExpression = true;
				} else {
					char bracketToRemove;

					switch (bracketExpression.charAt(i)) {
					case ']':
						bracketToRemove = '[';
						break;
					case '}':
						bracketToRemove = '{';
						break;
					default:
						bracketToRemove = '(';
						break;
					}

					if (brackets.peek() != bracketToRemove) {
						invalidExpression = true;
					} else {
						brackets.pop();
					}
				}
			} else {
				invalidExpression = true;
			}

			if (invalidExpression == true) {
				break;
			}
		}

		if (!invalidExpression && brackets.isEmpty()) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}

		scan.close();
	}
}