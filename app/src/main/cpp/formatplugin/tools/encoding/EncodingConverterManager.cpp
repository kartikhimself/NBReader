// author : newbiechen
// date : 2019-10-06 19:13
// description : 
//

#include <util/StringUtil.h>

#include "EncodingConverterManager.h"
#include "ASCIIEncodingConverter.h"
#include "UTF8EncodingConverter.h"
#include "UTF16EncodingConverter.h"

EncodingConverterManager *EncodingConverterManager::sInstance = nullptr;

EncodingConverterManager &EncodingConverterManager::getInstance() {
    if (sInstance == nullptr) {
        sInstance = new EncodingConverterManager();
    }
    return *sInstance;
}

EncodingConverterManager::EncodingConverterManager() {
    // ascii 转换器
    registerProvider(std::dynamic_pointer_cast<EncodingConvertProvider>(
            std::make_shared<ASCIIEncodingConvertProvider>()));
    // utf-8 转换器
    registerProvider(std::dynamic_pointer_cast<EncodingConvertProvider>(
            std::make_shared<UTF8EncodingConvertProvider>()));
    // utf-16 转换器
    registerProvider(std::dynamic_pointer_cast<EncodingConvertProvider>(
            std::make_shared<UTF16EncodingConvertProvider>()));
}

void EncodingConverterManager::registerProvider(std::shared_ptr<EncodingConvertProvider> provider) {
    mProviders.push_back(provider);
}

std::shared_ptr<EncodingConverter>
EncodingConverterManager::getEncodingConverter(const std::string &charset) const {
    for (auto provider : mProviders) {
        if (provider->isSupportConverter(charset)) {
            return provider->createConverter(charset);
        }
    }
    return nullptr;
}

std::shared_ptr<EncodingConverter> EncodingConverterManager::getDefaultConverter() const {
    return getEncodingConverter(Charset::UTF8);
}