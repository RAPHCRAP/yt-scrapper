package com.raph.util;

import com.microsoft.playwright.Playwright;

public class PlaywrightInstaller {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            System.out.println("Downloading Playwright browsers...");
        }
    }
}
