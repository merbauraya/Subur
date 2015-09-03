create table Subur_Author (
	authorId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	title VARCHAR2(75 CHAR) null,
	idType number(30,0),
	remoteId VARCHAR2(75 CHAR) null,
	firstName VARCHAR2(75 CHAR) null,
	lastName VARCHAR2(75 CHAR) null,
	middleName VARCHAR2(75 CHAR) null,
	userId number(30,0),
	metadata VARCHAR2(75 CHAR) null,
	lastPublishedDate timestamp null,
	itemCount number(30,0),
	createDate timestamp null,
	modifiedDate timestamp null,
	Uuid VARCHAR2(75 CHAR) null,
	createdBy number(30,0)
);

create table Subur_AuthorExpertise (
	authorId number(30,0) not null,
	expertiseId number(30,0) not null,
	primary key (authorId, expertiseId)
);

create table Subur_AuthorSite (
	authorSiteId number(30,0) not null primary key,
	authorId number(30,0),
	siteName VARCHAR2(75 CHAR) null,
	siteURL VARCHAR2(150 CHAR) null
);

create table Subur_DownloadSummary (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0),
	status number(30,0)
);

create table Subur_Expertise (
	expertiseId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	createDate timestamp null,
	expertiseName VARCHAR2(75 CHAR) null,
	indexedName VARCHAR2(75 CHAR) null,
	modifiedDate timestamp null,
	authorCount number(30,0)
);

create table Subur_Item (
	itemId number(30,0) not null primary key,
	companyId number(30,0),
	groupId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	publishedDate timestamp null,
	title VARCHAR2(255 CHAR) null,
	itemAbstract clob null,
	language VARCHAR2(75 CHAR) null,
	status number(30,0),
	Uuid VARCHAR2(75 CHAR) null,
	metadataValue clob null
);

create table Subur_ItemAuthor (
	itemId number(30,0) not null,
	authorId number(30,0) not null,
	primary key (itemId, authorId)
);

create table Subur_ItemFileEntry (
	itemId number(30,0) not null,
	fileEntryId number(30,0) not null,
	entryType number(30,0),
	primary key (itemId, fileEntryId)
);

create table Subur_ItemItemType (
	itemId number(30,0) not null,
	itemTypeId number(30,0) not null,
	primary key (itemId, itemTypeId)
);

create table Subur_ItemType (
	itemTypeId number(30,0) not null primary key,
	itemTypeName VARCHAR2(75 CHAR) null,
	itemCount number(30,0)
);

create table Subur_ItemTypeTemplate (
	itemTypeId number(30,0) not null,
	metadataPropertyId number(30,0) not null,
	required number(1, 0),
	primary key (itemTypeId, metadataPropertyId)
);

create table Subur_MetadataProperty (
	metadataPropertyId number(30,0) not null primary key,
	metadataSchemaId number(30,0),
	element VARCHAR2(255 CHAR) null,
	scope VARCHAR2(255 CHAR) null,
	note VARCHAR2(1024 CHAR) null
);

create table Subur_MetadataPropertyValue (
	metadataPropertyValueId number(30,0) not null primary key,
	itemId number(30,0),
	propertyId number(30,0),
	textValue clob null,
	itemCount number(30,0)
);

create table Subur_MetadataSchema (
	metadataSchemaId number(30,0) not null primary key,
	metadataName VARCHAR2(1024 CHAR) null,
	nameSpace VARCHAR2(75 CHAR) null
);

create table Subur_StatDownloadCategory (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	categoryId number(30,0)
);

create table Subur_StatDownloadItemType (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	itemTypeId number(30,0)
);

create table Subur_StatDownloadPeriod (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0)
);

create table Subur_StatDownloadTag (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	tagId number(30,0)
);

create table Subur_StatViewCategory (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	categoryId number(30,0)
);

create table Subur_StatViewItemType (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	itemTypeId number(30,0)
);

create table Subur_StatViewTag (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	tagId number(30,0)
);

create table Subur_ViewSummary (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0),
	status number(30,0)
);

create table item (
	itemId number(30,0) not null primary key,
	companyId number(30,0),
	groupId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	title VARCHAR2(75 CHAR) null,
	itemAbstract VARCHAR2(75 CHAR) null,
	status number(30,0)
);

create table subur_Author (
	authorId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	title VARCHAR2(75 CHAR) null,
	idType number(30,0),
	remoteId VARCHAR2(75 CHAR) null,
	firstName VARCHAR2(75 CHAR) null,
	lastName VARCHAR2(75 CHAR) null,
	userId number(30,0),
	metadata VARCHAR2(75 CHAR) null,
	lastPublishedDate timestamp null,
	itemCount number(30,0),
	personalSite VARCHAR2(75 CHAR) null,
	googleScholar VARCHAR2(120 CHAR) null
);

create table subur_AuthorExpertise (
	authorId number(30,0) not null,
	expertiseId number(30,0) not null,
	primary key (authorId, expertiseId)
);

create table subur_Division (
	divisionId number(30,0) not null primary key,
	parentId number(30,0),
	divisionName VARCHAR2(75 CHAR) null,
	depositable number(1, 0)
);

create table subur_DownloadSummary (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0),
	status number(30,0)
);

create table subur_Expertise (
	expertiseId number(30,0) not null primary key,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	createDate timestamp null,
	expertiseName VARCHAR2(75 CHAR) null,
	indexedName VARCHAR2(75 CHAR) null,
	modifiedDate timestamp null,
	authorCount number(30,0)
);

create table subur_FileEntryType (
	typeId number(30,0) not null primary key,
	typeName VARCHAR2(75 CHAR) null
);

create table subur_Item (
	itemId number(30,0) not null primary key,
	companyId number(30,0),
	groupId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	title VARCHAR2(1024 CHAR) null,
	itemAbstract varchar2(4000) null,
	status number(30,0)
);

create table subur_ItemAuthor (
	itemId number(30,0) not null,
	authorId number(30,0) not null,
	primary key (itemId, authorId)
);

create table subur_ItemDivision (
	itemId number(30,0) not null,
	divisionId number(30,0) not null,
	primary key (itemId, divisionId)
);

create table subur_ItemFileEntry (
	itemId number(30,0) not null,
	fileEntryId number(30,0) not null,
	entryType number(30,0),
	primary key (itemId, fileEntryId)
);

create table subur_ItemItemType (
	itemId number(30,0) not null,
	itemTypeId number(30,0) not null,
	primary key (itemId, itemTypeId)
);

create table subur_ItemSubject (
	itemId number(30,0) not null,
	subjectId number(30,0) not null,
	primary key (itemId, subjectId)
);

create table subur_ItemType (
	ItemTypeId number(30,0) not null primary key,
	ItemTypeName VARCHAR2(75 CHAR) null,
	itemCount number(30,0)
);

create table subur_ItemTypeTemplate (
	itemTypeId number(30,0) not null,
	metadataPropertyId number(30,0) not null,
	required number(1, 0),
	primary key (itemTypeId, metadataPropertyId)
);

create table subur_MetadataProperty (
	metadataPropertyId number(30,0) not null primary key,
	metadataSchemaId number(30,0),
	element VARCHAR2(255 CHAR) null,
	scope VARCHAR2(255 CHAR) null,
	note VARCHAR2(1024 CHAR) null
);

create table subur_MetadataPropertyValue (
	metadataPropertyValueId number(30,0) not null primary key,
	itemId number(30,0),
	propertyId number(30,0),
	textValue clob null,
	itemCount number(30,0)
);

create table subur_MetadataSchema (
	metadataSchemaId number(30,0) not null primary key,
	metadataName VARCHAR2(1024 CHAR) null,
	nameSpace VARCHAR2(75 CHAR) null
);

create table subur_MetadataValue (
	metadataValueId number(30,0) not null primary key,
	itemId number(30,0),
	propertyId number(30,0),
	textValue VARCHAR2(75 CHAR) null
);

create table subur_MetadataValueView (
	propertyId number(30,0) not null,
	subjectId number(30,0) not null,
	subjectName VARCHAR2(75 CHAR) null,
	textValue VARCHAR2(75 CHAR) null,
	itemCount number(30,0),
	primary key (propertyId, subjectId)
);

create table subur_StatDownloadCategory (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	categoryId number(30,0)
);

create table subur_StatDownloadItemType (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	itemTypeId number(30,0)
);

create table subur_StatDownloadPeriod (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0)
);

create table subur_StatDownloadTag (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	tagId number(30,0)
);

create table subur_StatViewCategory (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	categoryId number(30,0)
);

create table subur_StatViewItemType (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	itemTypeId number(30,0)
);

create table subur_StatViewPeriod (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0)
);

create table subur_StatViewTag (
	id_ number(30,0) not null primary key,
	perMonth number(30,0),
	perYear number(30,0),
	tagId number(30,0)
);

create table subur_Subject (
	subjectId number(30,0) not null primary key,
	parentId number(30,0),
	subjectName VARCHAR2(75 CHAR) null,
	lft number(30,0),
	rgt number(30,0),
	depositable number(1, 0),
	itemCount number(30,0)
);

create table subur_SubjectTree (
	subjectId number(30,0) not null primary key,
	parentId number(30,0),
	subjectName VARCHAR2(75 CHAR) null,
	lft number(30,0),
	rgt number(30,0),
	depositable number(1, 0),
	itemCount number(30,0)
);

create table subur_ViewSummary (
	id_ number(30,0) not null primary key,
	itemId number(30,0),
	perMonth number(30,0),
	perYear number(30,0),
	status number(30,0)
);

create table subur_item (
	itemId number(30,0) not null primary key,
	companyId number(30,0),
	groupId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	publishedDate timestamp null,
	title VARCHAR2(255 CHAR) null,
	itemAbstract clob null,
	language VARCHAR2(75 CHAR) null,
	status number(30,0),
	Uuid VARCHAR2(75 CHAR) null,
	metadataValue clob null
);
