package ru.thedevs.security.service;

public interface IEncryptionService {
  String encrypt(String data);

  String decrypt(String data);
}
