package com.konyk.service;

import java.util.List;

import com.konyk.model.Storage;

public interface StorageService {
	public void add(Storage storage);
	public void edit(Storage storage);
	public void delete(Integer storageId);
	public void deleteAll();
	public Storage getStorageById(Integer storageId);
	public List<Storage> getAllStorages();
}
