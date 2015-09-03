create table Subur_Author (
	authorId int64 not null primary key,
	groupId int64,
	companyId int64,
	title varchar(75),
	idType integer,
	remoteId varchar(75),
	firstName varchar(75),
	lastName varchar(75),
	middleName varchar(75),
	userId integer,
	metadata varchar(75),
	lastPublishedDate timestamp,
	itemCount integer,
	createDate timestamp,
	modifiedDate timestamp,
	Uuid varchar(75),
	createdBy int64
);

create table Subur_AuthorExpertise (
	authorId int64 not null,
	expertiseId int64 not null,
	primary key (authorId, expertiseId)
);

create table Subur_AuthorSite (
	authorSiteId int64 not null primary key,
	authorId int64,
	siteName varchar(75),
	siteURL varchar(150)
);

create table Subur_DownloadSummary (
	id_ int64 not null primary key,
	itemId int64,
	perMonth integer,
	perYear integer,
	status integer
);

create table Subur_Expertise (
	expertiseId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	createDate timestamp,
	expertiseName varchar(75),
	indexedName varchar(75),
	modifiedDate timestamp,
	authorCount integer
);

create table Subur_Item (
	itemId int64 not null primary key,
	companyId int64,
	groupId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	publishedDate timestamp,
	title varchar(255),
	itemAbstract blob,
	language varchar(75),
	status integer,
	Uuid varchar(75),
	metadataValue blob
);

create table Subur_ItemAuthor (
	itemId int64 not null,
	authorId int64 not null,
	primary key (itemId, authorId)
);

create table Subur_ItemFileEntry (
	itemId int64 not null,
	fileEntryId int64 not null,
	entryType int64,
	primary key (itemId, fileEntryId)
);

create table Subur_ItemItemType (
	itemId int64 not null,
	itemTypeId int64 not null,
	primary key (itemId, itemTypeId)
);

create table Subur_ItemType (
	itemTypeId int64 not null primary key,
	itemTypeName varchar(75),
	itemCount integer
);

create table Subur_ItemTypeTemplate (
	itemTypeId int64 not null,
	metadataPropertyId int64 not null,
	required smallint,
	primary key (itemTypeId, metadataPropertyId)
);

create table Subur_MetadataProperty (
	metadataPropertyId int64 not null primary key,
	metadataSchemaId int64,
	element varchar(255),
	scope varchar(255),
	note varchar(1024)
);

create table Subur_MetadataPropertyValue (
	metadataPropertyValueId int64 not null primary key,
	itemId int64,
	propertyId int64,
	textValue blob,
	itemCount integer
);

create table Subur_MetadataSchema (
	metadataSchemaId int64 not null primary key,
	metadataName varchar(1024),
	nameSpace varchar(75)
);

create table Subur_StatDownloadCategory (
	id_ int64 not null primary key,
	perMonth integer,
	perYear integer,
	categoryId int64
);

create table Subur_StatDownloadItemType (
	id_ int64 not null primary key,
	perMonth integer,
	perYear integer,
	itemTypeId int64
);

create table Subur_StatDownloadPeriod (
	id_ int64 not null primary key,
	itemId int64,
	perMonth integer,
	perYear integer
);

create table Subur_StatDownloadTag (
	id_ int64 not null primary key,
	perMonth integer,
	perYear integer,
	tagId int64
);

create table Subur_StatViewCategory (
	id_ int64 not null primary key,
	perMonth integer,
	perYear integer,
	categoryId int64
);

create table Subur_StatViewItemType (
	id_ int64 not null primary key,
	perMonth integer,
	perYear integer,
	itemTypeId int64
);

create table Subur_StatViewTag (
	id_ int64 not null primary key,
	perMonth integer,
	perYear integer,
	tagId int64
);

create table Subur_ViewSummary (
	id_ int64 not null primary key,
	itemId int64,
	perMonth integer,
	perYear integer,
	status integer
);

create table item (
	itemId int64 not null primary key,
	companyId int64,
	groupId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	title varchar(75),
	itemAbstract varchar(75),
	status integer
);

create table subur_Author (
	authorId int64 not null primary key,
	groupId int64,
	companyId int64,
	title varchar(75),
	idType integer,
	remoteId varchar(75),
	firstName varchar(75),
	lastName varchar(75),
	userId integer,
	metadata varchar(75),
	lastPublishedDate timestamp,
	itemCount integer,
	personalSite varchar(75),
	googleScholar varchar(120)
);

create table subur_AuthorExpertise (
	authorId int64 not null,
	expertiseId int64 not null,
	primary key (authorId, expertiseId)
);

create table subur_Division (
	divisionId int64 not null primary key,
	parentId int64,
	divisionName varchar(75),
	depositable smallint
);

create table subur_DownloadSummary (
	id_ int64 not null primary key,
	itemId int64,
	perMonth integer,
	perYear integer,
	status integer
);

create table subur_Expertise (
	expertiseId int64 not null primary key,
	groupId int64,
	companyId int64,
	userId int64,
	createDate timestamp,
	expertiseName varchar(75),
	indexedName varchar(75),
	modifiedDate timestamp,
	authorCount integer
);

create table subur_FileEntryType (
	typeId int64 not null primary key,
	typeName varchar(75)
);

create table subur_Item (
	itemId int64 not null primary key,
	companyId int64,
	groupId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	title varchar(1024),
	itemAbstract varchar(4000),
	status integer
);

create table subur_ItemAuthor (
	itemId int64 not null,
	authorId int64 not null,
	primary key (itemId, authorId)
);

create table subur_ItemDivision (
	itemId int64 not null,
	divisionId int64 not null,
	primary key (itemId, divisionId)
);

create table subur_ItemFileEntry (
	itemId int64 not null,
	fileEntryId int64 not null,
	entryType int64,
	primary key (itemId, fileEntryId)
);

create table subur_ItemItemType (
	itemId int64 not null,
	itemTypeId int64 not null,
	primary key (itemId, itemTypeId)
);

create table subur_ItemSubject (
	itemId int64 not null,
	subjectId int64 not null,
	primary key (itemId, subjectId)
);

create table subur_ItemType (
	ItemTypeId int64 not null primary key,
	ItemTypeName varchar(75),
	itemCount integer
);

create table subur_ItemTypeTemplate (
	itemTypeId int64 not null,
	metadataPropertyId int64 not null,
	required smallint,
	primary key (itemTypeId, metadataPropertyId)
);

create table subur_MetadataProperty (
	metadataPropertyId int64 not null primary key,
	metadataSchemaId int64,
	element varchar(255),
	scope varchar(255),
	note varchar(1024)
);

create table subur_MetadataPropertyValue (
	metadataPropertyValueId int64 not null primary key,
	itemId int64,
	propertyId int64,
	textValue blob,
	itemCount integer
);

create table subur_MetadataSchema (
	metadataSchemaId int64 not null primary key,
	metadataName varchar(1024),
	nameSpace varchar(75)
);

create table subur_MetadataValue (
	metadataValueId int64 not null primary key,
	itemId int64,
	propertyId int64,
	textValue varchar(75)
);

create table subur_MetadataValueView (
	propertyId int64 not null,
	subjectId int64 not null,
	subjectName varchar(75),
	textValue varchar(75),
	itemCount integer,
	primary key (propertyId, subjectId)
);

create table subur_StatDownloadCategory (
	id_ int64 not null primary key,
	perMonth integer,
	perYear integer,
	categoryId int64
);

create table subur_StatDownloadItemType (
	id_ int64 not null primary key,
	perMonth integer,
	perYear integer,
	itemTypeId int64
);

create table subur_StatDownloadPeriod (
	id_ int64 not null primary key,
	itemId int64,
	perMonth integer,
	perYear integer
);

create table subur_StatDownloadTag (
	id_ int64 not null primary key,
	perMonth integer,
	perYear integer,
	tagId int64
);

create table subur_StatViewCategory (
	id_ int64 not null primary key,
	perMonth integer,
	perYear integer,
	categoryId int64
);

create table subur_StatViewItemType (
	id_ int64 not null primary key,
	perMonth integer,
	perYear integer,
	itemTypeId int64
);

create table subur_StatViewPeriod (
	id_ int64 not null primary key,
	itemId int64,
	perMonth integer,
	perYear integer
);

create table subur_StatViewTag (
	id_ int64 not null primary key,
	perMonth integer,
	perYear integer,
	tagId int64
);

create table subur_Subject (
	subjectId int64 not null primary key,
	parentId int64,
	subjectName varchar(75),
	lft integer,
	rgt integer,
	depositable smallint,
	itemCount integer
);

create table subur_SubjectTree (
	subjectId int64 not null primary key,
	parentId int64,
	subjectName varchar(75),
	lft integer,
	rgt integer,
	depositable smallint,
	itemCount integer
);

create table subur_ViewSummary (
	id_ int64 not null primary key,
	itemId int64,
	perMonth integer,
	perYear integer,
	status integer
);

create table subur_item (
	itemId int64 not null primary key,
	companyId int64,
	groupId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	publishedDate timestamp,
	title varchar(255),
	itemAbstract blob,
	language varchar(75),
	status integer,
	Uuid varchar(75),
	metadataValue blob
);
