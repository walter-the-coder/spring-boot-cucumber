#lang: en
Feature: Events

  Scenario: Should publish and listen to events when application starts
    When an event with message "Howdy" is published
    Then our event listener should receive and event with message "Howdy"
